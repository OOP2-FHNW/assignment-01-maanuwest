package portfolio;

import portfolio.investments.Investment;
import portfolio.investments.Share;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Portfolio<T extends Investment>{
    private List<T> portfolio = new ArrayList<>();

    public boolean contains(T investment){
        return portfolio.contains(investment);
    }

    public void buy(T t){
        for(int i=0; i<portfolio.size();i++){
            if ( portfolio.get(i).equals(t) ) {
                double oldCount = portfolio.get(i).getCount();
                double newCount = t.getCount();
                double toAdd = oldCount + newCount;
                portfolio.get(i).setCount(toAdd);
                return;
            }
        }
        portfolio.add(t);
    }

    public void sell(String s, double amount){
            if (getShare(s) != null) {
                T t = getShare(s);
                double oldCount = t.getCount();
                double newCount = oldCount - amount;

                if(amount == oldCount){
                    portfolio.remove(t);
                    t.setCount(0);
                }else if(amount < oldCount) {
                    t.setCount(newCount);
                }else{
                    //TODO: error sell amount is bigger than portfolio
                    return;
                }
            }
    }

    public T getShare(String s){
        for(int i=0; i<portfolio.size();i++){
            if ( portfolio.get(i).getTitel().equals(s) ) {
                return portfolio.get(i);
            }
        }
        return null;
    }

}
