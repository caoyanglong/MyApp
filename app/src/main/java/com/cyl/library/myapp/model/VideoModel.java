package com.cyl.library.myapp.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VideoModel {
    private PageBean page;
    private ResultBean result;

    public VideoModel(JSONObject object) {

        JSONObject pageObject = object.optJSONObject("page");
        if (pageObject != null) {
            this.page = new PageBean(pageObject);
        }
        JSONObject resultObject = object.optJSONObject("result");
        if (resultObject != null) {
            this.result = new ResultBean(resultObject);
        }
    }

    public PageBean getPage() {
        return this.page;
    }

    public ResultBean getResult() {
        return this.result;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class PageBean {
        private AdCountBean adCount;
        private int topicId;
        private EditorCommentBean editorComment;
        private int pageId;
        private String title;
        private AlsoPlayGamesBean alsoPlayGames;
        private String detail;
        private int likeCount;
        private String pageTitle;
        private ActionBean action;
        private int playCount;
        private int followCount;
        private boolean isPriase;
        private List videos;
        private List hotComments;
        private List cards;

        public PageBean(JSONObject object) {

            this.topicId = object.optInt("topicId");
            this.pageId = object.optInt("pageId");
            this.title = object.optString("title");
            this.detail = object.optString("detail");
            this.likeCount = object.optInt("likeCount");
            this.pageTitle = object.optString("pageTitle");
            this.playCount = object.optInt("playCount");
            this.followCount = object.optInt("followCount");
            this.isPriase = object.optBoolean("isPriase");
            JSONObject adCountObject = object.optJSONObject("adCount");
            if (adCountObject != null) {
                this.adCount = new AdCountBean(adCountObject);
            }
            JSONObject editorCommentObject = object.optJSONObject("editorComment");
            if (editorCommentObject != null) {
                this.editorComment = new EditorCommentBean(editorCommentObject);
            }
            JSONObject alsoPlayGamesObject = object.optJSONObject("alsoPlayGames");
            if (alsoPlayGamesObject != null) {
                this.alsoPlayGames = new AlsoPlayGamesBean(alsoPlayGamesObject);
            }
            JSONObject actionObject = object.optJSONObject("action");
            if (actionObject != null) {
                this.action = new ActionBean(actionObject);
            }
            JSONArray videosArray = object.optJSONArray("videos");
            if (videosArray != null) {
                this.videos = new ArrayList<>();
                for (int i = 0; i < videosArray.length(); i++) {
                    this.videos.add(new VideosBean(videosArray.optJSONObject(i)));
                }
            }
            JSONArray hotCommentsArray = object.optJSONArray("hotComments");
            if (hotCommentsArray != null) {
                this.hotComments = new ArrayList<>();
                for (int i = 0; i < hotCommentsArray.length(); i++) {
                    this.hotComments.add(new HotCommentsBean(hotCommentsArray.optJSONObject(i)));
                }
            }
            JSONArray cardsArray = object.optJSONArray("cards");
            if (cardsArray != null) {
                this.cards = new ArrayList<>();
                for (int i = 0; i < cardsArray.length(); i++) {
                    this.cards.add(cardsArray.optString(i));
                }
            }
        }

        public AdCountBean getAdCount() {
            return this.adCount;
        }

        public int getTopicId() {
            return this.topicId;
        }

        public EditorCommentBean getEditorComment() {
            return this.editorComment;
        }

        public int getPageId() {
            return this.pageId;
        }

        public String getTitle() {
            return this.title;
        }

        public AlsoPlayGamesBean getAlsoPlayGames() {
            return this.alsoPlayGames;
        }

        public String getDetail() {
            return this.detail;
        }

        public int getLikeCount() {
            return this.likeCount;
        }

        public String getPageTitle() {
            return this.pageTitle;
        }

        public ActionBean getAction() {
            return this.action;
        }

        public int getPlayCount() {
            return this.playCount;
        }

        public int getFollowCount() {
            return this.followCount;
        }

        public boolean getIsPriase() {
            return this.isPriase;
        }

        public List getVideos() {
            return this.videos;
        }

        public List getHotComments() {
            return this.hotComments;
        }

        public List getCards() {
            return this.cards;
        }

        public void setAdCount(AdCountBean adCount) {
            this.adCount = adCount;
        }

        public void setTopicId(int topicId) {
            this.topicId = topicId;
        }

        public void setEditorComment(EditorCommentBean editorComment) {
            this.editorComment = editorComment;
        }

        public void setPageId(int pageId) {
            this.pageId = pageId;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAlsoPlayGames(AlsoPlayGamesBean alsoPlayGames) {
            this.alsoPlayGames = alsoPlayGames;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public void setPageTitle(String pageTitle) {
            this.pageTitle = pageTitle;
        }

        public void setAction(ActionBean action) {
            this.action = action;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public void setFollowCount(int followCount) {
            this.followCount = followCount;
        }

        public void setIsPriase(boolean isPriase) {
            this.isPriase = isPriase;
        }

        public void setVideos(List videos) {
            this.videos = videos;
        }

        public void setHotComments(List hotComments) {
            this.hotComments = hotComments;
        }

        public void setCards(List cards) {
            this.cards = cards;
        }

        public static class AdCountBean {
            private int GDTTotalCount;
            private String GDTId;

            public AdCountBean(JSONObject object) {

                this.GDTTotalCount = object.optInt("GDTTotalCount");
                this.GDTId = object.optString("GDTId");
            }

            public int getGDTTotalCount() {
                return this.GDTTotalCount;
            }

            public String getGDTId() {
                return this.GDTId;
            }

            public void setGDTTotalCount(int GDTTotalCount) {
                this.GDTTotalCount = GDTTotalCount;
            }

            public void setGDTId(String GDTId) {
                this.GDTId = GDTId;
            }
        }

        public static class EditorCommentBean {
            private String content;
            private String avatar;
            private String name;

            public EditorCommentBean(JSONObject object) {

                this.content = object.optString("content");
                this.avatar = object.optString("avatar");
                this.name = object.optString("name");
            }

            public String getContent() {
                return this.content;
            }

            public String getAvatar() {
                return this.avatar;
            }

            public String getName() {
                return this.name;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class AlsoPlayGamesBean {
            private boolean isShowFoot;
            private int cardId;
            private List items;

            public AlsoPlayGamesBean(JSONObject object) {

                this.isShowFoot = object.optBoolean("isShowFoot");
                this.cardId = object.optInt("cardId");
                JSONArray itemsArray = object.optJSONArray("items");
                if (itemsArray != null) {
                    this.items = new ArrayList<>();
                    for (int i = 0; i < itemsArray.length(); i++) {
                        this.items.add(new ItemsBean(itemsArray.optJSONObject(i)));
                    }
                }
            }

            public boolean getIsShowFoot() {
                return this.isShowFoot;
            }

            public int getCardId() {
                return this.cardId;
            }

            public List getItems() {
                return this.items;
            }

            public void setIsShowFoot(boolean isShowFoot) {
                this.isShowFoot = isShowFoot;
            }

            public void setCardId(int cardId) {
                this.cardId = cardId;
            }

            public void setItems(List items) {
                this.items = items;
            }

            public static class ItemsBean {
                private String description;
                private String title;
                private String subheading;
                private ActionBean action;
                private DownloadInfoBean downloadInfo;
                private String icon;

                public ItemsBean(JSONObject object) {

                    this.description = object.optString("description");
                    this.title = object.optString("title");
                    this.subheading = object.optString("subheading");
                    this.icon = object.optString("icon");
                    JSONObject actionObject = object.optJSONObject("action");
                    if (actionObject != null) {
                        this.action = new ActionBean(actionObject);
                    }
                    JSONObject downloadInfoObject = object.optJSONObject("downloadInfo");
                    if (downloadInfoObject != null) {
                        this.downloadInfo = new DownloadInfoBean(downloadInfoObject);
                    }
                }

                public String getDescription() {
                    return this.description;
                }

                public String getTitle() {
                    return this.title;
                }

                public String getSubheading() {
                    return this.subheading;
                }

                public ActionBean getAction() {
                    return this.action;
                }

                public DownloadInfoBean getDownloadInfo() {
                    return this.downloadInfo;
                }

                public String getIcon() {
                    return this.icon;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setSubheading(String subheading) {
                    this.subheading = subheading;
                }

                public void setAction(ActionBean action) {
                    this.action = action;
                }

                public void setDownloadInfo(DownloadInfoBean downloadInfo) {
                    this.downloadInfo = downloadInfo;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public static class ActionBean {
                    private int actionType;
                    private String actionTarget;

                    public ActionBean(JSONObject object) {

                        this.actionType = object.optInt("actionType");
                        this.actionTarget = object.optString("actionTarget");
                    }

                    public int getActionType() {
                        return this.actionType;
                    }

                    public String getActionTarget() {
                        return this.actionTarget;
                    }

                    public void setActionType(int actionType) {
                        this.actionType = actionType;
                    }

                    public void setActionTarget(String actionTarget) {
                        this.actionTarget = actionTarget;
                    }
                }

                public static class DownloadInfoBean {
                    private String gameId;
                    private int downloadType;
                    private int minSdk;
                    private int verCode;
                    private String gameName;
                    private String downloadUrl;
                    private String iconUrl;
                    private String pkgName;
                    private int ggVerCode;
                    private DownloadLinksBean downloadLinks;
                    private List gpuRenderers;

                    public DownloadInfoBean(JSONObject object) {

                        this.gameId = object.optString("gameId");
                        this.downloadType = object.optInt("downloadType");
                        this.minSdk = object.optInt("minSdk");
                        this.verCode = object.optInt("verCode");
                        this.gameName = object.optString("gameName");
                        this.downloadUrl = object.optString("downloadUrl");
                        this.iconUrl = object.optString("iconUrl");
                        this.pkgName = object.optString("pkgName");
                        this.ggVerCode = object.optInt("ggVerCode");
                        JSONObject downloadLinksObject = object.optJSONObject("downloadLinks");
                        if (downloadLinksObject != null) {
                            this.downloadLinks = new DownloadLinksBean(downloadLinksObject);
                        }
                        JSONArray gpuRenderersArray = object.optJSONArray("gpuRenderers");
                        if (gpuRenderersArray != null) {
                            this.gpuRenderers = new ArrayList<>();
                            for (int i = 0; i < gpuRenderersArray.length(); i++) {
                                this.gpuRenderers.add(gpuRenderersArray.optInt(i));
                            }
                        }
                    }

                    public String getGameId() {
                        return this.gameId;
                    }

                    public int getDownloadType() {
                        return this.downloadType;
                    }

                    public int getMinSdk() {
                        return this.minSdk;
                    }

                    public int getVerCode() {
                        return this.verCode;
                    }

                    public String getGameName() {
                        return this.gameName;
                    }

                    public String getDownloadUrl() {
                        return this.downloadUrl;
                    }

                    public String getIconUrl() {
                        return this.iconUrl;
                    }

                    public String getPkgName() {
                        return this.pkgName;
                    }

                    public int getGgVerCode() {
                        return this.ggVerCode;
                    }

                    public DownloadLinksBean getDownloadLinks() {
                        return this.downloadLinks;
                    }

                    public List getGpuRenderers() {
                        return this.gpuRenderers;
                    }

                    public void setGameId(String gameId) {
                        this.gameId = gameId;
                    }

                    public void setDownloadType(int downloadType) {
                        this.downloadType = downloadType;
                    }

                    public void setMinSdk(int minSdk) {
                        this.minSdk = minSdk;
                    }

                    public void setVerCode(int verCode) {
                        this.verCode = verCode;
                    }

                    public void setGameName(String gameName) {
                        this.gameName = gameName;
                    }

                    public void setDownloadUrl(String downloadUrl) {
                        this.downloadUrl = downloadUrl;
                    }

                    public void setIconUrl(String iconUrl) {
                        this.iconUrl = iconUrl;
                    }

                    public void setPkgName(String pkgName) {
                        this.pkgName = pkgName;
                    }

                    public void setGgVerCode(int ggVerCode) {
                        this.ggVerCode = ggVerCode;
                    }

                    public void setDownloadLinks(DownloadLinksBean downloadLinks) {
                        this.downloadLinks = downloadLinks;
                    }

                    public void setGpuRenderers(List gpuRenderers) {
                        this.gpuRenderers = gpuRenderers;
                    }

                    public static class DownloadLinksBean {
                        private List webview;
                        private List direct;

                        public DownloadLinksBean(JSONObject object) {

                            JSONArray webviewArray = object.optJSONArray("webview");
                            if (webviewArray != null) {
                                this.webview = new ArrayList<>();
                                for (int i = 0; i < webviewArray.length(); i++) {
                                    this.webview.add(webviewArray.optString(i));
                                }
                            }
                            JSONArray directArray = object.optJSONArray("direct");
                            if (directArray != null) {
                                this.direct = new ArrayList<>();
                                for (int i = 0; i < directArray.length(); i++) {
                                    this.direct.add(new DirectBean(directArray.optJSONObject(i)));
                                }
                            }
                        }

                        public List getWebview() {
                            return this.webview;
                        }

                        public List getDirect() {
                            return this.direct;
                        }

                        public void setWebview(List webview) {
                            this.webview = webview;
                        }

                        public void setDirect(List direct) {
                            this.direct = direct;
                        }

                        public static class DirectBean {
                            private String url;
                            private String name;
                            private String desc;

                            public DirectBean(JSONObject object) {

                                this.url = object.optString("url");
                                this.name = object.optString("name");
                                this.desc = object.optString("desc");
                            }

                            public String getUrl() {
                                return this.url;
                            }

                            public String getName() {
                                return this.name;
                            }

                            public String getDesc() {
                                return this.desc;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public void setDesc(String desc) {
                                this.desc = desc;
                            }
                        }
                    }
                }
            }
        }

        public static class ActionBean {
            private String actionUrl;
            private String htmlStandard;
            private String htmlUrl;
            private String htmlSuper;

            public ActionBean(JSONObject object) {

                this.actionUrl = object.optString("actionUrl");
                this.htmlStandard = object.optString("htmlStandard");
                this.htmlUrl = object.optString("htmlUrl");
                this.htmlSuper = object.optString("htmlSuper");
            }

            public String getActionUrl() {
                return this.actionUrl;
            }

            public String getHtmlStandard() {
                return this.htmlStandard;
            }

            public String getHtmlUrl() {
                return this.htmlUrl;
            }

            public String getHtmlSuper() {
                return this.htmlSuper;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public void setHtmlStandard(String htmlStandard) {
                this.htmlStandard = htmlStandard;
            }

            public void setHtmlUrl(String htmlUrl) {
                this.htmlUrl = htmlUrl;
            }

            public void setHtmlSuper(String htmlSuper) {
                this.htmlSuper = htmlSuper;
            }
        }

        public static class VideosBean {
            private String htmlStandard;
            private String habitUrl;
            private int videoId;
            private String htmlSuper;
            private String duration;
            private String playCount;
            private String thumb;
            private String title;
            private String url;
            private boolean isPortrait;
            private boolean showAd;
            private boolean showGDTAd;
            private List nakedUrls;

            public VideosBean(JSONObject object) {

                this.htmlStandard = object.optString("htmlStandard");
                this.habitUrl = object.optString("habitUrl");
                this.videoId = object.optInt("videoId");
                this.htmlSuper = object.optString("htmlSuper");
                this.duration = object.optString("duration");
                this.playCount = object.optString("playCount");
                this.thumb = object.optString("thumb");
                this.title = object.optString("title");
                this.url = object.optString("url");
                this.isPortrait = object.optBoolean("isPortrait");
                this.showAd = object.optBoolean("showAd");
                this.showGDTAd = object.optBoolean("showGDTAd");
                JSONArray nakedUrlsArray = object.optJSONArray("nakedUrls");
                if (nakedUrlsArray != null) {
                    this.nakedUrls = new ArrayList<>();
                    for (int i = 0; i < nakedUrlsArray.length(); i++) {
                        this.nakedUrls.add(nakedUrlsArray.optString(i));
                    }
                }
            }

            public String getHtmlStandard() {
                return this.htmlStandard;
            }

            public String getHabitUrl() {
                return this.habitUrl;
            }

            public int getVideoId() {
                return this.videoId;
            }

            public String getHtmlSuper() {
                return this.htmlSuper;
            }

            public String getDuration() {
                return this.duration;
            }

            public String getPlayCount() {
                return this.playCount;
            }

            public String getThumb() {
                return this.thumb;
            }

            public String getTitle() {
                return this.title;
            }

            public String getUrl() {
                return this.url;
            }

            public boolean getIsPortrait() {
                return this.isPortrait;
            }

            public boolean getShowAd() {
                return this.showAd;
            }

            public boolean getShowGDTAd() {
                return this.showGDTAd;
            }

            public List getNakedUrls() {
                return this.nakedUrls;
            }

            public void setHtmlStandard(String htmlStandard) {
                this.htmlStandard = htmlStandard;
            }

            public void setHabitUrl(String habitUrl) {
                this.habitUrl = habitUrl;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }

            public void setHtmlSuper(String htmlSuper) {
                this.htmlSuper = htmlSuper;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public void setPlayCount(String playCount) {
                this.playCount = playCount;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setIsPortrait(boolean isPortrait) {
                this.isPortrait = isPortrait;
            }

            public void setShowAd(boolean showAd) {
                this.showAd = showAd;
            }

            public void setShowGDTAd(boolean showGDTAd) {
                this.showGDTAd = showGDTAd;
            }

            public void setNakedUrls(List nakedUrls) {
                this.nakedUrls = nakedUrls;
            }
        }

        public static class HotCommentsBean {
            private String comment;
            private int topicId;
            private String name;
            private String avatarUrl;
            private QuoteBean quote;
            private int commentCount;
            private int likedCount;
            private String time;
            private String device;
            private int postId;
            private int groupId;

            public HotCommentsBean(JSONObject object) {

                this.comment = object.optString("comment");
                this.topicId = object.optInt("topicId");
                this.name = object.optString("name");
                this.avatarUrl = object.optString("avatarUrl");
                this.commentCount = object.optInt("commentCount");
                this.likedCount = object.optInt("likedCount");
                this.time = object.optString("time");
                this.device = object.optString("device");
                this.postId = object.optInt("postId");
                this.groupId = object.optInt("groupId");
                JSONObject quoteObject = object.optJSONObject("quote");
                if (quoteObject != null) {
                    this.quote = new QuoteBean(quoteObject);
                }
            }

            public String getComment() {
                return this.comment;
            }

            public int getTopicId() {
                return this.topicId;
            }

            public String getName() {
                return this.name;
            }

            public String getAvatarUrl() {
                return this.avatarUrl;
            }

            public QuoteBean getQuote() {
                return this.quote;
            }

            public int getCommentCount() {
                return this.commentCount;
            }

            public int getLikedCount() {
                return this.likedCount;
            }

            public String getTime() {
                return this.time;
            }

            public String getDevice() {
                return this.device;
            }

            public int getPostId() {
                return this.postId;
            }

            public int getGroupId() {
                return this.groupId;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public void setTopicId(int topicId) {
                this.topicId = topicId;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public void setQuote(QuoteBean quote) {
                this.quote = quote;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public void setLikedCount(int likedCount) {
                this.likedCount = likedCount;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public void setDevice(String device) {
                this.device = device;
            }

            public void setPostId(int postId) {
                this.postId = postId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            public static class QuoteBean {
                private String quotedFrom;
                private String quotedContent;
                private int level;

                public QuoteBean(JSONObject object) {

                    this.quotedFrom = object.optString("quotedFrom");
                    this.quotedContent = object.optString("quotedContent");
                    this.level = object.optInt("level");
                }

                public String getQuotedFrom() {
                    return this.quotedFrom;
                }

                public String getQuotedContent() {
                    return this.quotedContent;
                }

                public int getLevel() {
                    return this.level;
                }

                public void setQuotedFrom(String quotedFrom) {
                    this.quotedFrom = quotedFrom;
                }

                public void setQuotedContent(String quotedContent) {
                    this.quotedContent = quotedContent;
                }

                public void setLevel(int level) {
                    this.level = level;
                }
            }
        }
    }

    public static class ResultBean {
        private String msg;
        private int code;

        public ResultBean(JSONObject object) {

            this.msg = object.optString("msg");
            this.code = object.optInt("code");
        }

        public String getMsg() {
            return this.msg;
        }

        public int getCode() {
            return this.code;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}