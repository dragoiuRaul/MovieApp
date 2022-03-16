import React from "react";
import "./home.css";
import NotificationUtils from "../utils/notificationUtils.js";
import FetchUtils from "../utils/fetchUtils.js"; 

import { withTranslation } from 'react-i18next';

class Home extends React.Component {

		constructor(props) {
		super(props);
		this.state = {
			users: [],
			mystyle: {
				color: "white",
				backgroundColor: "DodgerBlue",
				padding: "10px",
				fontFamily: "Arial"
			}
		};
	}

	loadFromServer() {
		FetchUtils.get("http://localhost:8080/movie-app/api/users")
			.then(res => res.json())
			.then(
				(data) => {
					this.setState({ users: data.content });
					NotificationUtils.displayNotification(data.status);

				});
	}

	componentDidMount() {
		this.loadFromServer();
	}

	render() {
		const { t } = this.props;
		return (
			<div>
				<h1 className="text-center"> List</h1>
				<table>
					<thead>
						<tr>

							<td>{t('firstname')}</td>
							<td>{t('lastname')}</td>
							<td>{t('description')}</td>
						</tr>

					</thead>
					<tbody>
						{
							this.state.users.map(
								user =>
									<tr key={user.id}>
										<td> {user.firstName}</td>
										<td> {user.lastName}</td>
										<td> {user.email}</td>
									</tr>
							)
						}

					</tbody>
				</table>

			</div>

		)
	}
}
export default withTranslation()(Home);
