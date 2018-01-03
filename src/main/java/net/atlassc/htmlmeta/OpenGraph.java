package net.atlassc.htmlmeta;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class OpenGraph {

    private String ogTitle;
    private String ogDescription;
    private String ogUrl;
    private String ogImage;
    private String ogType;
    private String ogImageUrl;
    private String ogImageSecureUrl;
    private String ogImageType;
    private String ogSiteName;
    private int ogImageWidth;
    private int ogImageHeight;

    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public String getOgTitle() {
        return ogTitle;
    }

    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    public String getOgDescription() {
        return ogDescription;
    }

    public void setOgUrl(String ogUrl) {
        this.ogUrl = ogUrl;
    }

    public String getOgUrl() {
        return ogUrl;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public String getOgImage() {
        return ogImage;
    }


    public void setOgType(String ogType) {
        this.ogType = ogType;
    }

    public String getOgType() {
        return ogType;
    }

    public void setOgImageUrl(String ogImageUrl) {
        this.ogImageUrl = ogImageUrl;
    }

    public String getOgImageUrl() {
        return ogImageUrl;
    }

    public void setOgImageSecureUrl(String ogImageSecureUrl) {
        this.ogImageSecureUrl = ogImageSecureUrl;
    }

    public String getOgImageSecureUrl() {
        return ogImageSecureUrl;
    }

    public void setOgImageType(String ogImageType) {
        this.ogImageType = ogImageType;
    }

    public String getOgImageType() {
        return ogImageType;
    }

    public void setOgSiteName(String ogSiteName) {
        this.ogSiteName = ogSiteName;
    }


    public void setOgImageHeight(int ogImageHeight) {
        this.ogImageHeight = ogImageHeight;
    }

    public int getOgImageHeight() {
        return ogImageHeight;
    }

    public void setOgImageWidth(int ogImageWidth) {
        this.ogImageWidth = ogImageWidth;
    }

    public int getOgImageWidth() {
        return ogImageWidth;
    }

    public static OpenGraph parse(String html) {

        OpenGraph openGraph = new OpenGraph();
        Document doc = Jsoup.parse(html);
        Elements title = doc.select("meta[property=og:title]");
        if (title != null) {
            try {
                openGraph.setOgTitle(title.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements description = doc.select("meta[property=og:description]");
        if (description != null) {
            try {
                openGraph.setOgDescription(description.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements url = doc.select("meta[property=og:url]");
        if (url != null) {
            try {
                openGraph.setOgUrl(url.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements type = doc.select("meta[property=og:type]");
        if (type != null) {
            try {
                openGraph.setOgType(type.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements siteName = doc.select("meta[property=og:site_name]");
        if (siteName != null) {
            try {
                openGraph.setOgSiteName(siteName.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Elements image = doc.select("meta[property=og:image]");
        if (image != null) {
            try {
                openGraph.setOgImage(image.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements imageUrl = doc.select("meta[property=og:image:url]");
        if (imageUrl != null) {
            try {
                openGraph.setOgImageUrl(imageUrl.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements imageSecureUrl = doc.select("meta[property=og:image:secure_url]");
        if (imageSecureUrl != null) {
            try {
                openGraph.setOgImageSecureUrl(imageSecureUrl.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements imageType = doc.select("meta[property=og:image:type]");
        if (imageType != null) {
            try {
                openGraph.setOgImageType(imageType.attr("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements imageHeight = doc.select("meta[property=og:image:height]");
        if (imageHeight != null) {
            try {
                openGraph.setOgImageHeight(Integer.parseInt(imageHeight.attr("content")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Elements imageWidth = doc.select("meta[property=og:image:width]");
        if (imageWidth != null) {
            try {
                openGraph.setOgImageWidth(Integer.parseInt(imageWidth.attr("content")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return openGraph;
    }
}
