package notification;

import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class GestionNotification {
    public static void notification(String message, String NotificationTypetxt, Double duree) {
        TrayNotification notification = new TrayNotification();
        AnimationType type = AnimationType.POPUP;

        notification.setAnimationType(type);
        notification.setTitle("ExamApp");
        notification.setMessage(message);

        switch(NotificationTypetxt) {
            case "NOTICE":
                notification.setNotificationType(NotificationType.NOTICE);
                break;
            case "SUCCESS":
                notification.setNotificationType(NotificationType.SUCCESS);
                break;
            case "ERROR":
                notification.setNotificationType(NotificationType.ERROR);
                break;
            case "INFORMATION":
                notification.setNotificationType(NotificationType.INFORMATION);
                break;
            case "WARNING":
                notification.setNotificationType(NotificationType.WARNING);
                break;
            default:
                notification.setNotificationType(NotificationType.SUCCESS);
        }

        notification.showAndDismiss(Duration.seconds(duree));

    }
}
