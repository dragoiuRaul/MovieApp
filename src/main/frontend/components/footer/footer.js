import React from "react";

class Footer extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {
	}

	render() {
		return (
			<div className="footer">
				<footer className="py-2 bg-dark fixed-bottom">
					<div className="container">
						<p className="m-0 text-center text-white">
							Copyright &copy; Movie-App Dragoiu Muntean 2022
						</p>
					</div>
				</footer>
			</div>
		);
	}
}

export default Footer;
