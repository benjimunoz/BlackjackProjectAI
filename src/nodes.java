
// the nodes class helps build the player tree within the Expectiminimax AI
public class nodes {

    //This class is used for Expectiminimax.

    int val;
    nodes prev;

    nodes next;



    public nodes(int val){
    this.val=val; //represents the total cost
    this.prev=null;
    this.next=null;
    }
    public nodes(){
        this.val=0;
        this.prev=null;
        this.next=null;
    }



    public void setPrev(nodes n){
        this.prev=n;
    }

    public void setNext(nodes n){
        this.next=n;
    }
}
