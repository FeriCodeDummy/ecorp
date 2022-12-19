import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Login from "./components/Login.js"
import Register from "./components/Register"

import Profile from "./components/Profile";
import {RequireAuth} from "./components/RequireAuth";
import Home from "./components/Home";

import {AuthProvider, useAuth} from "./components/auth";
import Nav from "./components/Nav";
import Dashboard from './components/Dashboard';
import MailTest from './components/MailTest';


function App(){


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
                  <Route path='/dashboard' element={<RequireAuth><Dashboard/></RequireAuth>}/>
                  <Route path='/email' element={<MailTest/>}/>
                </Routes>
              </header>
            </div>
          </Router>
        </AuthProvider>
      </React.StrictMode>
  )
}

export default App
