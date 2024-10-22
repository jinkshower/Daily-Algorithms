//import java.util.Arrays;
//import java.util.function.Function;
//
//public enum Tracker {
//    APPSFLYER("appsflyer", (args) -> sendAppsFlyerClickEvent(args[0], args[1], args[2]),
//            (args) -> sendAppsFlyerImpressionEvent(args[0], args[1], args[2])),
//    BRANCH("branch", (args) -> sendBranchClickEvent(args[0], args[1], args[2]), null),
//    ADJUST("adjust", (args) -> sendAdjustClickEvent(args[0], args[1], args[2]), null);
//
//    private final String trackerName;
//    private final Function<String[], Void> sendClickEvent;
//    private final Function<String[], Void> sendImpressionEvent;
//
//    Tracker(String trackerName, Function<String[], Void> sendClickEvent,
//            Function<String[], Void> sendImpressionEvent) {
//        this.trackerName = trackerName;
//        this.sendClickEvent = sendClickEvent;
//        this.sendImpressionEvent = sendImpressionEvent;
//    }
//
//    public static Tracker of(String trackerName) {
//        return Arrays.stream(values())
//                .filter(tracker -> tracker.trackerName.equals(trackerName))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Invalid tracker name: " + trackerName));
//    }
//
//    public void sendClickEvent(String... args) {
//        sendClickEvent.apply(args);
//    }
//
//    public void sendImpressionEvent(String... args) {
//        if (sendImpressionEvent != null) {
//            sendImpressionEvent.apply(args);
//        }
//    }
//}
