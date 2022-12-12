import React from "react";
import '../css/components.css';
import { useNavigate } from 'react-router-dom'
import {useState} from "react";
import Axios from "axios";

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
		marginTop: "5px"
	}
}

function Register(){
	const navigate = useNavigate();
	const [registerUsername, setRegisterUsername] = useState("")
	const [registerPassword, setRegisterPassword] = useState("")
	const [registerEmail, setRegisterEmail] = useState("")
	const [registerName, setRegisterName] = useState("")
	const [registerSurname, setRegisterSurname] = useState("")
	const register = () => {
		Axios({
			method: "POST",
			data: {
				username: registerUsername,
				password: registerPassword,
				name: registerName,
				surname: registerSurname,
				email: registerEmail,
				wage: 0 // User is not being paid unless he works at the company
			},
			withCredentials: true,
			url: "http://localhost:8000/api/router.php/user/register",
		}).then((r =>{
				console.log(r);
			})
		).catch((err)=>{
			console.log(err);
		});
	};

	const handleSubmit = event => {
		event.preventDefault();
	};

	const reroute = (e)=>{
		e.preventDefault();
		navigate('/login');
	}

	return (


		<section className="justify-content-center" >
			<div className="container">
				<div className="row justify-content-center">
					<div className="col-lg-8">
						<div>
							<div className="form-input login-form">
								<h2 style={styles.h2Login}>Register Form</h2>
								<form onSubmit={handleSubmit} className="login-form">
									<div className="form-row">
										<div className="form-floating col-md-8">
											<input type="text" id="nameInput" className="form-control input-thingy" placeholder="Name"
												   onChange={(e) => setRegisterName(e.target.value)}/>
											<label htmlFor="nameInput">First name</label>

										</div>
										<div className="form-floating col-md-8">
											<input type="text" id="surname" className="form-control form-control-md input-thingy" placeholder="Surname"
												   onChange={(e) => setRegisterSurname(e.target.value)}/>
											<label htmlFor="surname">Last name</label>

										</div>
									</div>

									<div className="form-floating col-md-8">
										<input type="email" id="emailInput" className="form-control form-control-md input-thingy col-md-8" placeholder="Day of birth"
											   onChange={(e) => setRegisterEmail(e.target.value)}/>
										<label htmlFor="emailInput">Email</label>
									</div>


									<div className="form-floating col-md-8">
										<input type="text" id="username" className="form-control form-control-md input-thingy col-md-8" placeholder="Username"
											   onChange={(e) => setRegisterUsername(e.target.value)}/>
										<label htmlFor="username">Username</label>

									</div>
									<div className="form-floating col-md-8">
										<input type="password" id="password" className="form-control form-control-md input-thingy col-md-8" placeholder="Password"
											   onChange={(e) => setRegisterPassword(e.target.value)}/>
										<label htmlFor="password">Password</label>

									</div>

									<button type="submit" className="btn btn-primary" onClick={register}>Register</button>

									<div style={styles.divLogin}>
										<a style={styles.loginA} className="" onClick={reroute}
										>Already have an account?</a>
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




export default Register;
