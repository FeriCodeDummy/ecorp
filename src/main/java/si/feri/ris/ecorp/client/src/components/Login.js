import React from "react";
import '../css/components.css';
import { useNavigate } from 'react-router-dom'
import {useState} from "react";
import Axios from "axios";

import {useAuth} from './auth'
import api from '../services/api';
const styles = {
	h2Login: {
		textAlign: "center",
		fontSize: "25px"
	},
	divLogin: {
		textAlign:"center",
		paddingTop: "15px"
	},
	loginA: {
		fontSize: "15px"
	},
	margins: {
		paddingTop: "5px",
		marginTop: "5px"
	}
}

function Login(){

	const navigate = useNavigate();
	const [loginUsername, setLoginUsername] = useState("")
	const [loginPassword, setLoginPassword] = useState("")

	const auth = useAuth();
	const login = async () => {
		api.post('/users/login',
		 {
				username: loginUsername,
				password: loginPassword,
		 }
		 ).then((res) => {
				if(res.status === 200){
					console.log(res)
					auth.login(res.data);
					navigate('/');
				}else{
					console.log(res)
				}

			}

		).catch((err)=>{console.log(err)});
	};


	const handleSubmit = event => {
		event.preventDefault();
	};
	const reroute = (e)=>{
		e.preventDefault();
		navigate('/register');
	}

	return(
		<section className="justify-content-center" >
			<div className="container">
				<div className="row justify-content-center">
					<div className="col-lg-8">
						<div>
							<div className="form-input login-form">
								<h2 style={styles.h2Login}>Login Form</h2>
								<form onSubmit={handleSubmit} className="login-form">
									<div className="form-group">
										<input className="form-control form-control-md input-thingy" type="text" placeholder="username"
											   onChange={(e) => setLoginUsername(e.target.value)}
										/>

									</div>
									<div className="form-group ">
										<input className="form-control input-thingy" type="password" placeholder="password" id="password"
										   onChange={(e) => setLoginPassword(e.target.value)}
										/>

									</div>

									<div style={styles.margins} className="form-group">
										<button type="submit" className="btn btn-primary" onClick={login}>Login</button>
									</div>

									<div style={styles.divLogin}>
										<a style={styles.loginA} className="" onClick={reroute}
											>Don't have an account?</a>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</section>
	)
}



export default Login;
