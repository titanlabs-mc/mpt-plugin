package dev.titanlabs.mpt.apiwrapper.internal.request;

public class Route {

    public static final Route CLIENT_META = new Route("/data/self/metadata");
    public static final Route PACKAGE_META = new Route("/data/plugins/<pluginId>/metadata");
    public static final Route PACKAGE_FILE = new Route("/data/files/<fileId>");

    private final String route;
    private final int parameterCount;

    private Route(String route) {
        this.route = route;
        int parameterCount = 0;
        for (char character : route.toCharArray()) {
            if (character == '<') {
                parameterCount++;
            }
        }
        this.parameterCount = parameterCount;
    }

    public String getRoute() {
        return this.route;
    }

    public int getParameterCount() {
        return this.parameterCount;
    }

    public FilledRoute fill(String... parameters) {
        if (parameters.length != this.parameterCount) {
            throw new IllegalArgumentException("Could not fill out route '" + this.route + "' as the parameters specified didn't match the parameter count in the route " +
                    "(" + parameters.length + " != " + this.parameterCount + ").");
        }
        StringBuilder routeBuilder = new StringBuilder(this.route);
        for (int i = 0; i < this.parameterCount; i++) {
            int paramStartIndex = routeBuilder.indexOf("<");
            int paramEndIndex = routeBuilder.indexOf(">");
            routeBuilder.replace(paramStartIndex, paramEndIndex, parameters[i]);
        }
        return new FilledRoute(this, routeBuilder.toString());
    }

    public static class FilledRoute {
        private final Route originalRoute;
        private final String filledRoute;

        public FilledRoute(Route originalRoute, String filledRoute) {
            this.originalRoute = originalRoute;
            this.filledRoute = filledRoute;
        }

        public Route getOriginalRoute() {
            return this.originalRoute;
        }

        public String getFilledRoute() {
            return this.filledRoute;
        }
    }
}
