package net.atlassc.htmlmeta;

public class MetaInfo {

    private OpenGraph openGraph;

    public MetaInfo(String html) {
        this.openGraph = OpenGraph.parse(html);
    }
}
