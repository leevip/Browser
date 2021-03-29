package com.example.browser;


public class BrowserHistory {
    String[] history;
    int cursor;

    private static BrowserHistory browserHistory = new BrowserHistory();

    private BrowserHistory(){
        history = new String[]{null, null, null, null, null, null, null, null, null, null};
        cursor = 0;
    }

    public static BrowserHistory getInstance() {
        return browserHistory;
    }

    public void addHistoryItem(String url) {
        if (cursor == 9){
          for (cursor = 1; cursor < history.length; cursor++){
              history[cursor-1] = history[cursor];
          }
          cursor = 9;
          history[cursor] = url;
        } else {
            cursor++;
            history[cursor] = url;
            if (cursor < history.length-1){
                for (int i = cursor+1; i < history.length; i++){
                    history[i] = null;
                }
            }
        }
    }

    public String getPrevious(){
        if (cursor > 0){
            cursor--;
        } else {
            System.out.println("End of history");
        }
        return history[cursor];
    }

    public String getNext(){
        if (cursor < history.length-1){
            cursor++;
        } else {
            System.out.println("End of future");
        }
        return history[cursor];
    }

    public int getIndex(){ return cursor; }

    public int getLength(){ return history.length; }
}
