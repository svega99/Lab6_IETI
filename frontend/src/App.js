import React, {Component}  from 'react';
import './App.css';
import UserList from './components/UserList';

class App extends Component {

  constructor(props) {
      super(props);
      this.state = {
          userList: [],
      };
  }
  
  
  componentDidMount() {
      fetch('https://pure-shelf-97232.herokuapp.com/user')
          .then(response => response.json())
          .then(data => {
              let usersList = [];
              data.items.forEach(function (user) {
                  usersList.push({
                    correo:user.correo,
                    nombre:user.nombre,
                    contrasena: user.contrasena
                })

              });
              this.setState({userList: usersList});
          });
  }

  render() {
      return (
          <div>
              <UserList usersList={this.state.userList}/>
			  
          </div>
      );
  }
}
export default App;
