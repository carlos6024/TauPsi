package com.asutaupsi.taupsi.services;

import android.os.AsyncTask;

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
        final ServiceCalls.SearchBrothersResponse response = new ServiceCalls.SearchBrothersResponse();
        response.Brothers = new ArrayList<>();


        //Done
        response.Brothers.add(new Brother(1,"Jorge Poncho Calderon",
                "I wanted a family away from home and I wanted to make a difference within the organization.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13432367_1329346337079507_7655884061677951407_n.jpg?oh=c15542e8775c734903ccbce7f79e6926&oe=57ED11E6",
                "Family and Human Development"
                ,"Fall 2011",
                "Call of duty is my favorite game!"
        ));



        //Done
        response.Brothers.add(new Brother(2,"Juan Reyes ",
                "I joined the fraternity because I wanted to get involved at the organization as ASU well serve my community. Tau Psi Omega was that and the support system I needed.",
                "http://i50.photobucket.com/albums/f315/carlos6024/juan_zpsfbhpactf.jpg",
                "Nonprofit Leadership"
                ,"Fall 2012",
                "I'm left handed"
        ));


        //Done
        response.Brothers.add(new Brother(3,"Erik Velazquez",
                "I joined for the brotherhood.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/1897023_875848752472192_2567355315155659408_n.jpg?oh=6f9997526ce899769f62004129351499&oe=5831B471",
                "Nonprofit Leadership"
                ,"Fall 2012",
                "I have traveled to nine different countries. "
        ));



        //Done
        response.Brothers.add(new Brother(4,"Luis Perez",
                "I joined Tau Psi Omega because coming from out of state, I knew I needed to get involved. The BrotherFireBase were very welcoming, receiving me with open arms. They have become a great support system, my family away from home",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-0/p206x206/10245362_698918546836207_4963752366666049372_n.jpg?oh=673aae14d6085284c69c070c610d3d11&oe=58292303",
                "Computer Information Systems"
                ,"Fall 2012",
                "My two hobbies are Powerlifting and Pokemon"
        ));


        //Missing Fernando Vazquez


        //Done
        response.Brothers.add(new Brother(5,"Robert Jacobson",
                " I never truly felt like I belonged somewhere until Tau Psi and I also wanted to learn about more cultures.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/1917824_1256111087750882_2608896872434511026_n.jpg?oh=0b6f6e111158c23f16a62194403d730a&oe=58239179",
                "Special Eduation"
                ,"Spring 2013",
                "I am planning to sail and teach in other countries."
        ));



        //Done
        response.Brothers.add(new Brother(6,"Carlos Valentin",
                "In high school I enjoyed giving back to my community. I joined the fraternity" +
                " as a way to continue doing so.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/11752037_1690941804468570_874516916355434059_n.jpg?oh=56cdb3b906e9ef647957d5df4fddcbc6&oe=5805FACE",
                "Mechanical Engineering"
                ,"Spring 2013",
                "I am the developer of this app! Well the Android Version lol "
                ));


        //Done
        response.Brothers.add(new Brother(7,"Gerardo Calderon" ,
                "I Joined Tau Psi Omega for the brotherhood",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-0/p206x206/10003539_383713618437225_1293172134_n.jpg?oh=8b602f88b0263da9063354e4678d7d46&oe=580A2430",
                "Biochemistry (Medicinal)","Spring 2014", "I am going to Russia next spring break"));


        //Done
        response.Brothers.add(new Brother(8,"Sergio Jimenez",
                "I felt that the people in the organization reflected the same beliefs that I have and I felt that you guys were what I am able to call a family away from home",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13087543_987308654689880_7747649146973341694_n.jpg?oh=3b354753b73be33c2b0169c8681731f2&oe=580F935D",
                "Applied Computing",
                "Fall 2014","I love shoes."));


        //Done
        response.Brothers.add(new Brother(9,"Johnny Flores" ,
                "I joined Tau Psi because of the brotherhood aspect. Older BrotherFireBase impacted me greatly during my time in High School. They showed me"
                + " the importance of Academics and community service.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13263951_1011320725617035_6216817284706228180_n.jpg?oh=2468eb36bc37b60ccf9c10c10bfee3b0&oe=57F12D37",
                "Political Science",
                "Fall 2014",
                "I once broke my arm with a Hula Hoop"));


        //Done
        response.Brothers.add(new Brother(10,"Uriel Valenzuela" ,
                "I joined Tau Psi because of the strong sense of brotherhood and commitment to service.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12190070_733902766714555_1820858226805004561_n.jpg?oh=5f4cf334f9f4cd2c6a99d667a1c01c20&oe=57EEC376",
                "Economics",
                "Fall 2014",
                "I completed my first rubiks cube last summer lol!"));



        //Boo bear missing


        //Done
        response.Brothers.add(new Brother(12,"Exercise and wellness" ,
                "I wanted to have a support system and meet like minded people that would be like my family away from home.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12239600_10204971185704258_8044837795689882516_n.jpg?oh=2379b9ba90f4031bd080afd38984fe91&oe=58289A52",
                "Exercise and Wellness",
                "Fall 2014",
                "I can eat more then any of my BrotherFireBase!"));



        //Done
        response.Brothers.add(new Brother(13,"David Ambriz" ,
                "I joined Tau Psi to have a family away from home that will support me through my studies and be there every step of the way.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13533337_1086951308025135_4295448763362429760_n.jpg?oh=b19941c41c972730a4bf8747dd310a30&oe=57EE1393",
                "Business Communication",
                "Fall 2014",
                "I have visited Easter Island, Chile"));






        //Done
        response.Brothers.add(new Brother(14,"Andres Calzadias",
                "I wanted to make connections that could positively influence me and help push me towards my goals",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13096017_523231151196987_1210654285430385905_n.jpg?oh=5b668d646c1bacc970084120320f84cd&oe=57F3B6A5",
                "Business Law "
                ,"Fall 2015",
                "I aspire to join the military after my studies!"
        ));






        //Picture added
        response.Brothers.add(new Brother(15, "Luciano Huapaya" ,
                "I joined Tau Psi because I saw how real the brotherhood was.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12800114_1225940224100661_6462293434383640631_n.jpg?oh=e87cfaf916afbbb925a6503fd69cd7a9&oe=583500A9",
                "Biomedical Engineering",
                "Fall 2015",
                "I like to play chess!"));




        //Done
        response.Brothers.add(new Brother(16,"Gerardo Linares" ,
                "I wanted somthing more for my college experience. What started as a joke actually made me join!",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12728766_189867211368779_4420617133060696791_n.jpg?oh=7bb1bad29dd50b8d6277bdf42d33df79&oe=57EDFA91",
                "Biochemistry (Medicinal)",
                "Spring 2014", "I really like to take things apart and putting them back together(cars)!"));



        //Done
        response.Brothers.add(new Brother(17,"Brandon Gerber" ,
                "I joined Tau Psi because I was seeking an amazing brotherhood where we would always be there for each other and I was seeking more connections and ways to get out there a develop life experiences to be able to further my life and future career. I also joined because I was seeking friendships that would last a lifetime.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12654157_10153208310721793_8587570469444360975_n.jpg?oh=6ad30524936eab8d4ef5b44844d6562e&oe=580C8B4A",
                "Family and Human Development",
                "Fall 2015", "I speak four languages!"));


        //Done
        response.Brothers.add(new Brother(50,"Matt Schurman" ,
                "I joined for the brotherhood and because I wanted to feel like I was making a difference in my community.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/11988665_1068439999856067_2781888327350999133_n.jpg?oh=98d02254d956a64a37fe0e88f74582d5&oe=5836E6F9",
                "Marketing",
                "Fall 2015", "I have broken my arm twice from skateboarding!"));


        //Done
        response.Brothers.add(new Brother(18,"Hector Trujillo" ,
                "So I joined Tau Psi because prior to to coming to ASU, one of the BrotherFireBase talked to me about it and I loved everything he told me about Tau Psi. I knew this was exactly what I was looking for in an organization when coming to ASU.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12717672_555720357911377_6429532760389944663_n.jpg?oh=5a03dfde477dfb66aaea93ae14ff3c8c&oe=5836A58A",
                "Global Health",
                "Fall 2015", "I am going to india next summer!"));


        //Done
        response.Brothers.add(new Brother(19,"Daniel Sanchez" ,
                "To expand my network and make life long BrotherFireBase who share common interests.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12042697_224285501253508_2795472914206112947_n.jpg?oh=79d4ae4ac0dc09940ba613821a9cde31&oe=57F85620",
                "Marketing",
                "Fall 2015 ",
                "I love anime and movies!"));




        //Done
        response.Brothers.add(new Brother(20,"Michael Jimenez" ,
                "I joined Tau Psi to get more involved with school, and to meet more people that go to ASU, and to build a brotherhood.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/10455691_772914262732728_7234217204765557049_n.jpg?oh=3e44c3cff757101311dd9638921f53d4&oe=57F20370",
                "Interdisciplinary Studies",
                "Fall 2015 ",
                "I used to watch a bunch of Hells Kitchen so I'm good at cooking."));



        //Done
        response.Brothers.add(new Brother(21,"Steven Marcinkowski" ,
                "I joined Tau Psi for the brotherhood.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-0/p206x206/541973_4267272798281_1729905950_n.jpg?oh=9cea723349966b1dfeca069a3a0b3561&oe=58258B86",
                "Digital Culture",
                "Fall 2015 ",
                "Im rebuilding a 78 Chevy Camaro!"));



        //Miguel Bautista Missing
        //Erick Jimenez missing



        //Done
        response.Brothers.add(new Brother(22,"Juan Panduro",
                "I joined Tau Psi Omega for a support system.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13346561_1105969719441159_11085801372326366_n.jpg?oh=00f2d53a8143989396b55e048ab1bc8e&oe=58074EFC",
                "Industrial Engineering"
                ,"Spring 2016",
                "I love trucks!"
        ));



        //manny missing


        //Done
        response.Brothers.add(new Brother(23, "Orlando Garcia",
                "I Joined Tau Psi Omega because it offer me a family outside a family. It is not just a usual social fraternity but they also focus in helping the community and education. Everyone in the fraternity treats each other with respect which makes a brotherhood bond even more meaningful.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/11223907_706573516115267_3782061748806350290_n.jpg?oh=f06c6238fd3d7f1e7f00616c0e033378&oe=57E88EB5",
                "Computer Science",
                "Spring 2016", "I aspire to either join the CIA or start my own company!"));


        //Done
        response.Brothers.add(new Brother(24, "Marcus Cortez",
                "I joined Tau Psi because I was sold on the informational and what you the fraternity stood for. ",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12006338_10207734198418904_3074070944832535824_n.jpg?oh=1fc44cfb57b43a5eaad4055633ecc2d4&oe=582B1EB9",
                "Global Logistics Management",
                "Spring 2016", "I like to attend music festivals and dance!"));


        //Done
        response.Brothers.add(new Brother(25, "Jagan Pandari",
                "I Joined Tau Psi Omega to branch out and make new friends and connections that I could really call BrotherFireBase!",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-0/p206x206/11259586_10203412651836005_3967091277814132478_n.jpg?oh=822eb11744d31019506650e2731d8c4c&oe=57E91E83",
                "Biomedical Engineering",
                "Spring 2016", "I do professional pubic speaking for fun!"));


        //Done
        response.Brothers.add(new Brother(26, "Chris Vollaire",
                "I joined because I wanted to do something that was bigger then myself. I wanted to help people and communities alike and the closeness between the BrotherFireBase were all the things that made me want to join Tau Psi Omega.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/12552576_1019378764770092_702413895574329850_n.jpg?oh=4c99c2e54ca2841f85f168af54497c0a&oe=58369E78",
                "Chemical Engineering",
                "Spring 2016", "I play Pokemon Go and I rep team instinct"));



        //Done
        response.Brothers.add(new Brother(27, "Carlos Estrada",
                "I joined because I wanted to be a leader like the BrotherFireBase of tau psi.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13055607_1293182864028774_3661645501700319171_n.jpg?oh=a1372b4e89c60365977dd57785b63cd7&oe=58274F30",
                "Business",
                "Spring 2016", "I own 11 watches!"));



        //Done
        response.Brothers.add(new Brother(28, "Enrique Sandoval",
                "I joined for networking and lifelong relationships.",
                "https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/13164367_1335066636508441_8240127874695438220_n.jpg?oh=13a2602cdd59fab938a34ea33cb7a929&oe=583356EE",
                "Design Studies",
                "Spring 2016", "I sing, play guitar, bass, Ukulele, clarinet, and harmonica."));
        bus.post(response);

    }
}
