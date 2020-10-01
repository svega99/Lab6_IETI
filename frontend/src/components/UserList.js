import React from 'react';
import {CardContent,Typography,Card} from '@material-ui/core';


export class UserList extends React.Component {

  constructor(props) {

    super(props);
  }

  render() { 


    const userList = this.props.usersList.map((user) => {
      console.log(user)
      return (
        <Card >
            <CardContent>
              <Typography  component="body1">
                Email: {user.correo}
              </Typography>

              <Typography  component="body1">
                Full Name: {user.nombre}
              </Typography>

              <Typography component="body1">
                Password: {user.contrasena}
              </Typography>

            </CardContent>
        </Card>

      );
    });


    return (
      <div>
        {userList}
      </div>
    );

  }

}

export default UserList;