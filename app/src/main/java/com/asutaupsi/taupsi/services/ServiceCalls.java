package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.entities.Brother;
import com.asutaupsi.taupsi.entities.EventPhoto;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.asutaupsi.taupsi.entities.RushEvent;

import java.util.List;

public class ServiceCalls {

    private ServiceCalls(){
    }


    public static class SearchBrothersRequest{
        public String searchType;

        public SearchBrothersRequest(String searchType) {
            this.searchType = searchType;
        }

    }


    public static class SearchBrothersResponse{
        public List<Brother> Brothers;
    }


    public static class SearchRushInfoEventsRequest {
        public String searchType;

        public SearchRushInfoEventsRequest(String searchType) {
            this.searchType = searchType;
        }
    }

    public static class SearchRushInfoEventsResponse {
        public List<RushEvent> rushInfoEvents;
    }


    public static class SearchRushCommunityEventsRequest{
        public String searchType;
        public SearchRushCommunityEventsRequest(String searchType) {
            this.searchType = searchType;
        }


    }


    public static class SearchRushCommunityResponse{
        public List<RushEvent> rushCommunityEvents;
    }


    public static class SearchRushSocialEventsRequest {
        public String searchType;

        public SearchRushSocialEventsRequest(String searchType) {
            this.searchType = searchType;
        }
    }

    public static class SearchRushSocialEventsResponse {
        public List<RushEvent> rushSocialEvents;
    }

    public static class SearchCommunityInformationRequest {
        public String SearchParam;

        public SearchCommunityInformationRequest(String searchParam) {
            SearchParam = searchParam;
        }
    }


    public static class SearchCommunityInformationResponse {
        public List<InformationCard> communityInformationList;
    }




    public static class SearchBrotherhoodInformationRequest {
        public String SearchParam;

        public SearchBrotherhoodInformationRequest(String searchParam) {
            SearchParam = searchParam;
        }
    }

    public static class SearchBrotherhoodInformationResponse {
        public List<InformationCard> brotherHoodInformationList;
    }


    public static class SearchSocialInformationRequest {
        public String SearchParam;

        public SearchSocialInformationRequest(String searchParam) {
            SearchParam = searchParam;
        }
    }

    public static class SearchSocialInformationResponse {
            public List<InformationCard> socialVideos;
    }




    public static class SearchBeALeaderPhotosRequest {
        public String SearchParameter;
        public SearchBeALeaderPhotosRequest(String searchParameter) {
            SearchParameter = searchParameter;
        }
    }


    public static class SearchBeALeaderPhotosResponse {
        public List<EventPhoto> BeALeaderPhotos;
    }




    public static class SearchTravelingPhotosRequest{
        public String SearchParameter;

        public SearchTravelingPhotosRequest(String searchParameter) {
            SearchParameter = searchParameter;
        }
    }

    public static class SearchTravelingPhotosResponse{
        public List<EventPhoto> TravelingEventPhotos;
    }


    public static class SearchSexyShowCaseRequest{
        public String SearchParameter;
        public SearchSexyShowCaseRequest(String searchParameter) {
            SearchParameter = searchParameter;
        }
    }

    public static class SearchSexyShowcaseResponse{
        public List<EventPhoto> SexyShowCasePhotos;
    }
}
