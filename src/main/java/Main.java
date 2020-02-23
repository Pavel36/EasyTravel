import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Graph distances=new Graph();
        JsonReader reader = new JsonReader();
        /*
        distances=reader.read("C:\\Users\\павел\\Desktop\\DistanceAlg\\src\\main\\resources\\example.json","DRIVING");
        distances=reader.addTravelMode(distances,"WALKING","C:\\Users\\павел\\Desktop\\DistanceAlg\\src\\main\\resources\\example2.json");
       */
        /*
        distances=reader.read("C:\\Users\\павел\\Desktop\\DistanceAlg\\src\\main\\resources\\testDriving.json","DRIVING");
        distances=reader.addTravelMode(distances,"WALKING","C:\\Users\\павел\\Desktop\\DistanceAlg\\src\\main\\resources\\testTransit.json");

        Node start = new Node();
        start=distances.searchNode("Гринвич, Великобритания");
        Node end = new Node();
        end=distances.searchNode("Dlouhá 609/2, 110 00 Praha-Staré Město, Чехия");
        ArrayList<Node> ex = new ArrayList<Node>();
        Long res=distances.shortestWay(start,end,ex);
        distances.createTreeFromNodes(start);
         */
        HashMap<String,Node> rs = new HashMap<String, Node>();
        rs = reader.readNodes("C:\\Users\\павел\\Desktop\\DistanceAlg\\src\\main\\resources\\voronezhDdriving.json");
        reader.readEdges(rs,"C:\\Users\\павел\\Desktop\\DistanceAlg\\src\\main\\resources\\voronezhDdriving.json","DRIVING");
        reader.readEdges(rs,"C:\\Users\\павел\\Desktop\\DistanceAlg\\src\\main\\resources\\voronezhTransit.json","TRANSIT");
        reader.readEdges(rs,"C:\\Users\\павел\\Desktop\\DistanceAlg\\src\\main\\resources\\voronezhWalking.json","WALKING");
        distances.setNodes(rs);
        Node start;
        start=distances.getNodes().get("б-р Победы, 23Б, Воронеж, Воронежская обл., Россия, 394077");
        Node end;
        end=distances.getNodes().get("ул. 20-летия Октября, 119, Воронеж, Воронежская обл., Россия, 394006");
        LinkedList<Edge> resWay = new LinkedList<Edge>();
       // LinkedList<Edge> minResWay=new LinkedList<Edge>();
      //  Long a = distances.shortestWay(start,end,resWay);
        int counter=0;
       Long sum = Long.valueOf(0);
       //Long minSum=Long.valueOf(999999999);
       // distances.shortGamiltoneWay(start,end, resWay, minResWay, counter,sum,minSum);
        distances.shortestWay(start,end,resWay,counter,sum);
        System.out.println("A");
    }
}
//https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Greenwich,+Greater+London,+UK|Stockholm%20County,%20Sweden|Dlouh%C3%A1%20609/2,%20110%2000%20Praha-Star%C3%A9%20M%C4%9Bsto,%20%C4%8Cesk%C3%A1%20republika&destinations=Greenwich,+Greater+London,+UK|Stockholm%20County,%20Sweden|Dlouh%C3%A1%20609/2,%20110%2000%20Praha-Star%C3%A9%20M%C4%9Bsto,%20%C4%8Cesk%C3%A1%20republika&key=AIzaSyBHCKPzyd6Wa4E9hT_FwSQOKBsZ-9qP8Go
//ChIJK3Nn-8YoO0EROEmqIs4WR5o
// ул, б-р Победы, 23Б, Воронеж, Воронежская обл., Россия, 394053|ул. Кольцовская, 35, Воронеж, Воронежская обл., Россия, 394030|Университетская пл., 1, Воронеж, Воронежская обл., Россия, 394036|Комиссаржевской ул., 4, Воронеж, Воронежская обл., Россия, 394036|ул. 20-летия Октября, 119, Воронеж, Воронежская обл., Россия, 394006
//ChIJT5iyMuUuO0ERZF768YDJYzk ул. Кольцовская, 35, Воронеж, Воронежская обл., Россия, 394030
//ChIJ_9rYsFkuO0ERWmCQtgVUAE4 Университетская пл., 1, Воронеж, Воронежская обл., Россия, 394036
//ChIJ7_AE7v0uO0ERBgkcGERgVR0 Комиссаржевской ул., 4, Воронеж, Воронежская обл., Россия, 394036
//ChIJMQVew_QuO0ERxOrErC6z4MA ул. 20-летия Октября, 119, Воронеж, Воронежская обл., Россия, 394006