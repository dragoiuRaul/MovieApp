import React from "react";
import { NavLink } from "react-router-dom";
import "./navigation.css";
import { withTranslation } from 'react-i18next';


class Navigation extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {
	}

	render() {
		const { t } = this.props;
		return (
			<div className="navigation">

				<nav className="navbar navbar-dark bg-dark">
					<ul className="nav justify-content-end">
						<li className="nav-item">
							<NavLink className="nav-link" to="/">
								{t('home')}
								<span className="sr-only">(current)</span>
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/about">
								{t('about')}
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/contact">
								{t('contact')}
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/blog">
								{t('blog')}
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/login">
								{t('login')}
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/registration">
								{t('register')}
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/location">
								{t('location')}
							</NavLink>
						</li>
					</ul>
					<ul className="nav navbar-nav navbar-right">
						<li><button onClick={sayHello} type="button" className="btn btn-primary btn-small btn-nav">Log Out</button></li>
					</ul>
				</nav>
			</div>
		);
	}
}

function sayHello() {
	alert('You clicked me!');
}

export default withTranslation()(Navigation);

;
