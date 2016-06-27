package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.entities.Brother;
import com.asutaupsi.taupsi.entities.EventPhoto;
import com.asutaupsi.taupsi.entities.InformationCard;
import com.asutaupsi.taupsi.entities.RushEvent;

import java.util.List;

public class ServiceCalls {

    private ServiceCalls(){
    }


    /////////////////////////////Brothers Service Calls//////////////////////////////////////
    public static class SearchBrothersRequest{
        public String searchType;

        public SearchBrothersRequest(String searchType) {
            this.searchType = searchType;
        }
    }


    public static class SearchBrothersResponse{
        public List<Brother> Brothers;
    }





    /////////////////////////////Rush Events Service Calls//////////////////////////////////////
    public static class SearchRushEventsRequest{
        public String searchType;

        public SearchRushEventsRequest(String searchType) {
            this.searchType = searchType;
        }
    }

    public static class SearchRushEventsResponse{
        public List<RushEvent> rushEvents;
    }






    /////////////////////////////Information Cards Service Calls//////////////////////////////////////
    public static class SearchCommunityInformationRequest {
        public boolean Search;

        public SearchCommunityInformationRequest(boolean search) {
            Search = search;
        }
    }


    public static class SearchCommunityInformationResponse {
        public List<InformationCard> communityInformationList;
    }




    public static class SearchAcademicsInformationRequest {
        public boolean Search;

        public SearchAcademicsInformationRequest(boolean search) {
            Search = search;
        }
    }

    public static class SearchAcademicsInformationResponse {
        public List<InformationCard> brotherHoodInformationList;
    }


    public static class SearchSocialInformationRequest {
        public boolean Search;

        public SearchSocialInformationRequest(boolean search) {
            Search = search;
        }

    }

    public static class SearchSocialInformationResponse {
            public List<InformationCard> socialVideos;
    }




    /////////////////////////////Photos Service Calls//////////////////////////////////////
    public static class SearchFormalPhotosRequest{
        public String SearchParameter;
        public SearchFormalPhotosRequest(String searchParameter) {
            SearchParameter = searchParameter;
        }
    }


    public static class SearchFormalPhotosResponse{
        public List<EventPhoto> FormalEventPhotos;
    }


}
