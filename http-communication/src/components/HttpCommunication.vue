<template>
  <div>
    <h1>
      Spring boot skeleton application without DB Connectivity
    </h1>
    <hr class="grayBorder" style="margin-bottom: 40px;width:40%">
    <div class="flex spaceBetween">
      <div class="flex">
        <h3 class="margin-right">List of users</h3>
        <button 
          class="btn"
          @click="getUsers"
        >
          Get list of users
        </button>
      </div>

      <form @submit.prevent="addUser" class="flex width200">  
        <input type="text" class="margin-right size" v-model="username" placeholder="Username">
        <input type="text" class="margin-right size" v-model="email" placeholder="Email">
        <input type="text" class="margin-right size" v-model="firstName" placeholder="First name">
        <input type="text" class="margin-right size" v-model="lastName" placeholder="Last name">
        <p>
          <button type="submit" class="btn">Create user</button>
        </p>
      </form>
    </div>
    <table>
      <tr>
        <th>UserName</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
      <tr
        v-for="(user, i) in users"
        :key="i"
      >
        <td>{{ user.username }}</td>
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.email }}</td>
        <td>
          <button class="btn margin-right" @click="editUser(user.id)">Edit</button>
          <button class="btn" @click="deleteUser(user.id)">Delete</button>
        </td>
      </tr>
    </table>
    <form @submit.prevent="uploadFile" class="column">
      <input type="file" id="myFile" name="filename">
      <input type="submit">
    </form>
    <div  v-if="response && response.data">
      <h5 style="text-decoration: underline;">
        Response from the backend application
      </h5>
      <h3>
        {{ response.data }}
      </h3>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import UserService from '../services/UserService';

export default {
  name: 'HttpCommunication',

  data() {
    return {
      response: null,
      username: "",
      firstName: "",
      lastName: "",
      email: "",
      users: [{
        username: "User name",
        firstName: "Fist name",
        lastName: "Last name",
        email: "Email"
      }]
    };
  },

  methods: {
    // async getListOfUsers() {
    //   //write the method you use on backend for getting all users
    //   //this.response = await axios.
      

    // },

    async getUsers(){
        UserService.getUsers().then((response)=>{
          this.users=response.data;
        });
      },


    async addUser() {
      //write the method you use on backend for adding

        
      this.response = await axios.post('http://localhost:8081/user', {
        headers: {
          'Accept': 'application/xml'
        },
        username: this.username,
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email
      })
    },
    async editUser() {
      //write the method you use on backend for editing user
      //this.response = await axios.
    },
    async deleteUser() {
      //write the you use on backend for deleting
      //this.response = await axios.
    },



    //this is a simple example how we can override headers
    async getXMLResponse() {
      this.response = await axios.post('', {}, {
        headers: {
          'Accept': 'application/xml'
        }
      })
    },

    async uploadFile() {
      // let formData = new FormData();
      // formData.append("file", document.getElementById("myFile")); 
      
        
      this.response = await axios.post('http://localhost:8081/users', document.getElementById('myFile') , {
        headers: {
          'Accept': 'application/png'
          
        }
      })
    },


    //this is a simple example how we can send value as RequestParam
    async getResponseWithRequestParam() {
      this.response = await axios.get(`http://localhost:8081/greeting?name=${ this.name }`)
    },
    //this is a simple example how we can send value as PathVariable
    async getResponseWithPathVariable() {
      this.response = await axios.get(`http://localhost:8081/greeting/${ this.name }/hello`)
    }
  }
}
</script>

<style scoped>
.column {
  display: flex;
  flex-direction: column;
}
.grayBorder {
  border: 1px solid gray;
}
.btn {
  height: 30px;
  margin-top: 6px;
  background-color: white;
  color: black;
  border: 1px solid gray;
}
.flex {
  display: flex;
  align-items: center;
}
.margin-right {
  margin-right: 5px;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}
.spaceBetween {
  justify-content: space-between;
}
.size {
  height: 30px;
  width: 70px;
}
</style>
