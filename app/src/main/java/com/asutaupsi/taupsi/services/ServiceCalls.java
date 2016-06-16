package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.services.entities.Brother;
import com.asutaupsi.taupsi.services.entities.InformationVideo;
import com.asutaupsi.taupsi.services.entities.RushEvent;

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



    public static class SearchRushEventsRequest{
        public String searchType;

        public SearchRushEventsRequest(String searchType) {
            this.searchType = searchType;
        }
    }

    public static class SearchRushEventsResponse{
        public List<RushEvent> rushEvents;
    }



    public static class SearchCommunityVideosRequest{
        public boolean Search;

        public SearchCommunityVideosRequest(boolean search) {
            Search = search;
        }
    }


    public static class SearchCommuntiyVideosResponse {
        public List<InformationVideo> communityVideos;
    }



}
