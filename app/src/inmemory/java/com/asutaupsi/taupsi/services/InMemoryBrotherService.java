package com.asutaupsi.taupsi.services;

import com.asutaupsi.taupsi.infrastructure.TauPsiApplication;
import com.asutaupsi.taupsi.entities.Brother;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryBrotherService extends BaseInMemeoryService {
    public InMemoryBrotherService(TauPsiApplication application) {
        super(application);
    }


    @Subscribe
    public void findBrother(final ServiceCalls.SearchBrothersRequest request){
        ServiceCalls.SearchBrothersResponse response = new ServiceCalls.SearchBrothersResponse();
        response.Brothers = new ArrayList<>();

        response.Brothers.add(new Brother(1,"Carlos Valentin", "In high school I enjoyed giving back to my community. I joined the fraternity" +
                "as a way to continue doing so.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/11752037_1690941804468570_874516916355434059_n.jpg?oh=56cdb3b906e9ef647957d5df4fddcbc6&oe=5805FACE",
                "Mechanical Engineering"
                ,"Spring 2013",
                "I made the developer of this app! Well the android version lol"
                ));


        response.Brothers.add(new Brother(2,"Juan Panduro", "I joined Tau Psi Omega for a support system. What I got was a family",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13346561_1105969719441159_11085801372326366_n.jpg?oh=00f2d53a8143989396b55e048ab1bc8e&oe=58074EFC",
                "Industrial Engineering"
                ,"Spring 2016",
                "I am about about that truck life!"
        ));


        response.Brothers.add(new Brother(3,"Jorge Poncho Calderon", "I wanted a family away from home and I wanted to make a difference within the organization.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13432367_1329346337079507_7655884061677951407_n.jpg?oh=c15542e8775c734903ccbce7f79e6926&oe=57ED11E6",
                "Family and Human Development"
                ,"Fall 2011",
                "Call of duty is my favorite game!"
        ));



        response.Brothers.add(new Brother(4,"Andres Calzadias", "I wanted a family away from home and I wanted to make a difference within the organization.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13096017_523231151196987_1210654285430385905_n.jpg?oh=5b668d646c1bacc970084120320f84cd&oe=57F3B6A5",
                "Business Law "
                ,"Fall 2015",
                "I aspire to join the marines!"
        ));



        response.Brothers.add(new Brother(5,"Juan Reyes", "I joined the fraternity because I wanted to get involved at the organization as ASU well serve my community. Tau Psi Omega was that and the support system I neeeded",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t34.0-12/13530683_1062224167199288_1269430085_n.jpg?oh=f8358f819e4b7bb827e59a0397272ec8&oe=57715B8B",
                "Nonprofit Leadership and Mangement"
                ,"Fall 2012",
                "I am left handed!"
        ));

        response.Brothers.add(new Brother(6,"Sergio Jimenez","I felt that the people in the organization reflected the same beliefs that I have and I felt that you guys were what I am able to call a family away from home",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13087543_987308654689880_7747649146973341694_n.jpg?oh=3b354753b73be33c2b0169c8681731f2&oe=580F935D",
                "Applied Computing","Fall 2014","I love shoes."));


        response.Brothers.add(new Brother(7,"Gerardo Calderon" ,"I Joined Tau Psi Omega for the brotherhood","https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-0/p206x206/10003539_383713618437225_1293172134_n.jpg?oh=8b602f88b0263da9063354e4678d7d46&oe=580A2430",
                "Biochemistry (Medicinal)","Spring 2014", "I am going to Russia next spring break"));


        response.Brothers.add(new Brother(8,"Luciano Huapaya" ,"I Joined Tau Psi Omega for the brotherhood","https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12662483_1201373246557359_7497573120856199668_n.jpg?oh=70c3648f8a2cd1b64db5114c5b1dad32&oe=57ED9B35",
                "Biochemistry (Medicinal)","Spring 2014", "I am going to Russia next spring break"));


        response.Brothers.add(new Brother(9,"Johnny Flores" ,"I Joined Tau Psi Omega for the brotherhood","https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13263951_1011320725617035_6216817284706228180_n.jpg?oh=2468eb36bc37b60ccf9c10c10bfee3b0&oe=57F12D37",
                "Biochemistry (Medicinal)","Spring 2014", "I am going to Russia next spring break"));



        response.Brothers.add(new Brother(10,"Gerardo Linares" ,"I Joined Tau Psi Omega for the brotherhood","https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12728766_189867211368779_4420617133060696791_n.jpg?oh=7bb1bad29dd50b8d6277bdf42d33df79&oe=57EDFA91",
                "Biochemistry (Medicinal)","Spring 2014", "I am going to Russia next spring break"));


        response.Brothers.add(new Brother(11,"Uriel Valenzuela" ,"I Joined Tau Psi Omega for the brotherhood","https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12190070_733902766714555_1820858226805004561_n.jpg?oh=5f4cf334f9f4cd2c6a99d667a1c01c20&oe=57EEC376",
                "Biochemistry (Medicinal)","Spring 2014", "I am going to Russia next spring break"));


        response.Brothers.add(new Brother(12,"Brandon Gerber" ,"I Joined Tau Psi Omega for the brotherhood","https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12654157_10153208310721793_8587570469444360975_n.jpg?oh=6ad30524936eab8d4ef5b44844d6562e&oe=580C8B4A",
                "Biochemistry (Medicinal)","Spring 2014", "I am going to Russia next spring break"));


        /*for(int i = 0 ; i<5;i++){
            String stringId = Integer.toString(i);

            response.Brothers.add(new Brother(i,
                    "Brother " + i,
                    "My name is Brother " + i + " and I love to Code my heart out!!!",
                    "http://www.gravatar.com/avatar/" + stringId + "?d=identicon",
                    "Mechanical Engineering",
                    "Spring 2013",
                    "I made this app"));
        }*/
        bus.post(response);
    }
}
