import React from 'react'; //ES6
import { Link } from 'react-router-dom';
import '../css/components.css'
import {useAuth} from "./auth";

function Nav(){
	const auth = useAuth()
	return (
		<nav className="navbar navbar-expand-lg bg-transparent">
				<div className="collapse navbar-collapse" id="navbarNav">
					<ul className="navbar-nav">

						<li className="nav-item">
							<Link to='/' className='nav-link'>Home</Link>
						</li>

						<li>
							{
								auth.user && (
									<Link to='/dashboard' className="nav-link">Dashboard</Link>
								)
							}
						</li>

						<li className="nav-item">
							{
								!auth.user && (
									<Link to='/login' className="nav-link">Prijava</Link>
								)
							}

						</li>

						<li className="nav-item">
							{
								!auth.user && (
									<Link to='/register' className="nav-link">Registracija</Link>
								)
							}
						</li>
						<li className="nav-item">
							{
								auth.user && (
									<Link to='/profile' className="nav-link">Profil</Link>
								)
							}
						</li>



					</ul>
				</div>
		</nav>
	);
}

export default Nav;

