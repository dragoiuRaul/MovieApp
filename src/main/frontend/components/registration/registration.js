const React = require('react');
const ReactDOM = require('react-dom');
import './registration.css';
import { withTranslation } from 'react-i18next';

class Registration extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {
	}

	render() {
		const { t } = this.props;
		return (

			<div className="formStyle">
				<div className="formStyle-heading">Registration</div>
				<form action="" method="post">
					<label>
						<span>{t('email')}</span>
						<input type="text" className="input-field" name="email" placeholder={t('emailplaceholder')} />
					</label>
					<label>
						<span>{t('username')}</span>
						<input type="text" className="input-field" name="username" placeholder={t('usernameplaceholder')} />
					</label>
					<label>
						<span>{t('password')}</span>
						<input type="password" className="input-field" name="password" placeholder={t('passwordplaceholder')}  />
					</label>
					<label>
						<span>{t('confirmpassword')}</span>
						<input type="password" className="input-field" name="confirm password" placeholder={t('passwordplaceholder')} />
					</label>
					<label>
					<br/>
						<span>{t('firstname')}</span>
						<input type="text" className="input-field" name="email" placeholder={t('firstnameplaceholder')} />
					</label>
					<label>
						<span>{t('lastname')}</span>
						<input type="text" className="input-field" name="email" placeholder={t('lastnameplaceholder')}/>
					</label>
					
					<label><span> </span>
						<input type="submit" value={t('register')} />
					</label>
				</form>
			</div>
		)


	}
}

export default withTranslation()(Registration);


