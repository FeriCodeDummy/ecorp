import  { useAuth } from "./auth";
import React from "react";
import { Navigate } from "react-router-dom";

export const RequireAuth = ({children}) => {
	const auth = useAuth();
	if (!auth.user){
		return <Navigate to='/login'/>
	}
	return children;
}