package net.atlassc.OpenGraphParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {

    public static OpenGraph parseOpenGraph(String html) {


        OpenGraph openGraph = new OpenGraph();
        Document doc = Jsoup.parse(html);
        Elements title = doc.select("meta[property=og:title]");
        if (title != null) {
            openGraph.setOgTitle(title.attr("content"));
        }
        Elements description = doc.select("meta[property=og:description]");
        if (description != null) {
            openGraph.setOgDescription(description.attr("content"));
        }
        Elements url = doc.select("meta[property=og:url]");
        if (url != null) {
            openGraph.setOgUrl(url.attr("content"));
        }
        Elements type = doc.select("meta[property=og:type]");
        if (type != null) {
            openGraph.setOgType(type.attr("content"));
        }


        Elements image = doc.select("meta[property=og:image]");
        if (image != null) {
            openGraph.setOgImage(image.attr("content"));
        }
        Elements imageUrl = doc.select("meta[property=og:image:url]");
        if (imageUrl != null) {
            openGraph.setOgImageUrl(image.attr("content"));
        }
        Elements imageSecureUrl = doc.select("meta[property=og:image:secure_url]");
        if (imageSecureUrl != null) {
            openGraph.setOgImageSecureUrl(image.attr("content"));
        }
        Elements imageType = doc.select("meta[property=og:image:type]");
        if (imageType != null) {
            openGraph.setOgImageType(image.attr("content"));
        }


        return openGraph;
    }

}
