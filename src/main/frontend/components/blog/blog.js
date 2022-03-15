import React from "react";
import { Outlet } from "react-router-dom";

class Blog extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {
	}

	render() {
		return (
			<div className="home">
				<div class="container">
					<h1 className="mt-5">This is a Post Title</h1>
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting
						industry. Lorem Ipsum has been the industry's standard dummy text ever
						since the 1500s, when an unknown printer took a galley of type and
						scrambled it to make a type specimen book.
					</p>
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting
						industry. Lorem Ipsum has been the industry's standard dummy text ever
						since the 1500s, when an unknown printer took a galley of type and
						scrambled it to make a type specimen book.
					</p>
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting
						industry. Lorem Ipsum has been the industry's standard dummy text ever
						since the 1500s, when an unknown printer took a galley of type and
					</p>
				</div>
			</div>
		);
	}
}

export default Blog;
