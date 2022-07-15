package com.lol.analysis.crawling;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.lol.analysis.dto.ChampTopTierDto;

@Service
public class ChampTierService{
	
	private static String Champ_Tier_Url = "https://www.op.gg/champions?region=kr&tier=all&position=jungle";
	
	@PostConstruct
	public void getChampTierDatas() throws IOException {
		
		Document doc = Jsoup.connect(Champ_Tier_Url).get();
		Elements contents = doc.select("table.e1oulx2j8 tbody tr");
		
//		for(Element content : contents) {
//			Elements tdContents = content.select("td");
//			
//			ChampTopTierDto champTierDto = ChampTopTierDto.builder()
//					.name(tdContents.get(1).text())
//					.winLate(tdContents.get(3).text())
//					.pickLate(tdContents.get(4).text())
//					.banLate(tdContents.get(5).text())
//					.tier(tdContents.get(2).text())
//					.build();
//					
//			System.out.println(champTierDto.toString());
//			
//		}
		
	}
	
}









