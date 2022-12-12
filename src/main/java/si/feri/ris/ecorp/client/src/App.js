import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Login from "./components/Login.js"
import Register from "./components/Register"

import Profile from "./components/Profile";
import {RequireAuth} from "./components/RequireAuth";
import Home from "./components/Home";

import {AuthProvider, useAuth} from "./components/auth";
import Nav from "./components/Nav";


function App(){

  /*
  const auth = useAuth();

  if("sid" in sessionStorage){
      Axios({
          method: "POST",
          data : {
              sid: sessionStorage.getItem("sid"),
          },
          url: "http://localhost:8000/api/router.php/user/sessionLogin"
      }).then((res)=>{
          if (res.status === 200){
              auth.login(res.data.user);
          }else if(res.status === 406){
              console.log(res.data.message);
          }
      });
  }*/
  // TODO persistent login by session_id saved in sessionStorage




  return(
      <React.StrictMode>
        <AuthProvider>
          <Router>
            <div className="App">
              <header>
                <Nav/>
                <Routes>
                  <Route path='/' element={<Home/>}/>
                  <Route path='/login' element={<Login/>} />
                  <Route path='/register' element={<Register/>}/>
                  <Route path='/profile' element={<RequireAuth><Profile/></RequireAuth>}/>


                </Routes>
              </header>
            </div>
          </Router>
        </AuthProvider>
      </React.StrictMode>
  )
}

export default App
