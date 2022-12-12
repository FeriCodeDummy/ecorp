import React, {useState} from "react";
import '../css/components.css';
import { useNavigate } from 'react-router-dom'
import Axios from "axios";

import homescreen from './img/homescreen.jpg';
import {Link} from 'react-router-dom';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
function Home(){

	const [style1, setStyle1] = useState({display: 'none'});
	const [style2, setStyle2] = useState({display: 'none'});


	return(
	<section>

		<h1>This is homepage</h1>
	</section>)


}

export default Home;
