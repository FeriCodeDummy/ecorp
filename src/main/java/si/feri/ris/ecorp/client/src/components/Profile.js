import React, {useState} from "react";
import {useLocation } from "react-router-dom";
import Axios from "axios";
import {useAuth} from "./auth";

function Profile(){

	const auth = useAuth();

	const [user, setUser] = useState(null);
	return (
		<div>
			Welcome {auth.user.username}, hope this works, your id is {auth.user.id}

		</div>
	);
}

export default Profile