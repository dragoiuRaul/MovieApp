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
								{t('greetings')}
								<span className="sr-only">(current)</span>
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/about">
								About
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/contact">
								Contact
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/blog">
								Blog
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/login">
								Login
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/registration">
								Register
							</NavLink>
						</li>
						<li className="nav-item">
							<NavLink className="nav-link" to="/location">
								Location
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
