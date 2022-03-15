const React = require('react');
const ReactDOM = require('react-dom');
import { Redirect, Link } from "react-router-dom";
import Registration from "../registration/registration";
import './login.css';

class Login extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {
	}


	redirectToRegister() {
		<Link to="/registration"></Link>
	}

	render() {
		return (

			<div class="formStyle">
				<div class="formStyle-heading">Movie Shop App</div>
				<form action="" method="get">
					<label>
						<span>username</span>
						<input type="text" class="input-field" name="username" placeholder="Enter username" />
					</label>
					<label>
						<span>password </span>
						<input type="password" class="input-field" name="password" placeholder="Enter password" />
					</label>
					<label><span> </span>
						<input type="submit" value="Log in" />
					</label>

					<label>
						<Link to="/registration" className="btn btn-primary">Sign up</Link>
					</label>
				</form>
			</div>
		)


	}

}

export default Login;

/*
setTimeOut(function() {
	ReactDom.render(<input value={null} />, Login);
}, 1000);*/
