import { Store } from 'react-notifications-component'
import 'react-notifications-component/dist/theme.css'




class NotificationUtils {
	static displayNotification(statusJson) {
		Store.addNotification({
			message: statusJson.messageDescription,
			type: statusJson.messageType,
			insert: "top",
			container: "top-center",
			animationIn: ["animate__animated", "animate__fadeIn"],
			animationOut: ["animate__animated", "animate__fadeOut"],
			dismiss: {
				duration: 5000,
				onScreen: true
			}
		});
	}
}
export default NotificationUtils;

