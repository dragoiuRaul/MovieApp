const React = require('react');
const ReactDOM = require('react-dom');
import { Redirect, Link } from "react-router-dom";
import Registration from "../registration/registration";
import './login.css';
import { withTranslation } from 'react-i18next';

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
		const { t } = this.props;
		return (

			<div className="formStyle">
				<div className="formStyle-heading">Movie Shop App</div>
				<form action="" method="get">
					<label>
						<span>{t('username')}</span>
						<input type="text" className="input-field" name="username" placeholder={t('usernameplaceholder')} />
					</label>
					<label>
						<span>{t('password')}</span>
						<input type="password" className="input-field" name="password" placeholder={t('passwordplaceholder')}  />
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

export default withTranslation()(Login);


