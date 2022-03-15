const React = require('react');
const ReactDOM = require('react-dom');
import './registration.css';

class Registration extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {
	}

	render() {
		return (

			<div class="formStyle">
				<div class="formStyle-heading">Registration</div>
				<form action="" method="post">
					<label>
						<span>email</span>
						<input type="text" class="input-field" name="email" placeholder="Enter email" />
					</label>
					<label>
						<span>username</span>
						<input type="text" class="input-field" name="username" placeholder="Enter username" />
					</label>
					
					<label>
						<span>password </span>
						<input type="password" class="input-field" name="password" placeholder="Enter password" />
					</label>
					<label>
						<span>confirm password</span>
						<input type="password" class="input-field" name="confirm password" placeholder="Confirm password" />
					</label>
					<label>
					<br/>
						<span>First name</span>
						<input type="text" class="input-field" name="email" placeholder="Enter First name" />
					</label>
					<label>
						<span>Last name</span>
						<input type="text" class="input-field" name="email" placeholder="Enter Last name" />
					</label>
					
					<label><span> </span>
						<input type="submit" value="Register" />
					</label>
				</form>
			</div>
		)


	}
}

export default Registration;


