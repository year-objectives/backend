package org.yearobjectives;

/**
 * This is a utils class to hold api spec constants (paths, header names, query param names, etc).
 */
public final class AppUtils {

    private AppUtils() {}
    /**
     * Paths util.
     */
    public static final class Paths {
            /**
             * Api base path.
             */
            protected static final String ROOT_PATH = "/api";
            
            private static final String API_VERSION_1 = "/v1";
            
            /**
             * Objectives path.
             */
            public static final String OBJECTIVES = API_VERSION_1 + "/objectives";

        private Paths(){}
    }
    /**
     * Headers util.
     */
    public static final class Headers {

        private Headers(){}
    }
    /**
     * Parameters util.
     */
    public static final class Parameters {

        private Parameters(){}
    }

    /**
     * Query parameters util.
     */
    public static final class QueryParameters {

        private QueryParameters(){}
    }

    /**
     * Request body util.
     */
    public static final class RequestBodies {

        public static final String OBJECTIVE = "ObjectiveInput";

        private RequestBodies(){}
        /**
         * Request body examples util.
         */
        public static final class Examples {


            public static final String OBJECTIVE = """
                            
                            """;

            private Examples() {}
        }
    }
    /**
     * Response body util.
     */
    public static final class ResponseDto {

        public static final String OBJECTIVE = "ObjectiveResponse";

        public static final String OBJECTIVE_MERKER = "ObjectiveMarkerResponse";

        public static final String OBJECTIVE_LIST = "ObjectiveListResponse";



        /**
         * Response body examples util.
         */
        public static final class Examples {

            public static final String OBJECTIVE = """
                    {
                        "id":"ff84904c-cb4f-4832-ba31-b6ef27bcad62",
                        "type":"WEEKLY",
                        "reversible":true,
                        "cells": [
                            {
                                "done":true,
                                "concluded_at":12345
                            }
                        ]

                        @JsonProperty UUID id, @JsonProperty ObjectiveType type, @JsonProperty Boolean reversible, 
                           @JsonProperty("cells") List<ObjectiveMarkerDto> objectiveMarkers
                    }
                """;

            public static final String OBJECTIVE_MARKER = """
                    {
                        "done":true,
                        "concluded_at":12345
                    }
                """;

            private Examples() {}
        }

        private ResponseDto(){}
    }
    /**
     * Misc- util.
     */
    public static final class Misc {
        /**
         * Metrics prefix.
         */
        public static final String METRICS_PREFIX = "yearly_objectives_";

        private Misc(){}
    }
}
