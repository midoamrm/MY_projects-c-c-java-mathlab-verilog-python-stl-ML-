package sample;

import java.util.ArrayList;

public class Trie {

        private TrieNode root;


        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie

        public void insert(String word,int id) {
            if(!search( word)) {// 3shan ataktd 2n mafesh 7aga hatt5san twiec
                TrieNode p = root;
                for(int i=0; i<word.length(); i++){
                    char c = word.charAt(i);
                    int index;
                    if((int)c<58 && (int)c>47) {
                        index = (int)c - 22;
                        //System.out.println("y5tyyyyyyy");
                    } else if((int)c<123 && (int)c>96)
                        index = c-'a';
                    else return;
                    //System.out.println(index);
                    if(p.arr[index]==null){
                        TrieNode temp = new TrieNode();
                        p.arr[index]=temp;
                        p = temp;
                    }else{
                        p=p.arr[index];
                    }
                }
                p.isEnd=true;
                p.id.add(id);//b55san id le kol word
            }
            else {
                TrieNode p = searchNode(word);
                if(p.id.get(p.id.size()-1) == id)
                    return;
                p.id.add(id); // ba5san id bta3t word el mtkrrar
                //System.out.println("REARTED!");

            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode p = searchNode(word);
            if(p==null){
                return false;
            }else{
                if(p.isEnd) {
                    //System.out.println(word+"[-");
            	/* for (Integer num :p.id) {
                     System.out.println(num);
            	 }
            	 */
                    // System.out.println("]");
                    return true;


                }
            }


            return false;
        }


        public ArrayList<Integer> GET_id(String word) {
            TrieNode p = searchNode(word);// bageeb al pointer
            if(p==null){
                return null;
            }else{
                if(p.isEnd) {

                    return (p.id);


                }
            }
            return null;
        }



        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) { // malhas lzama qyee
            TrieNode p = searchNode(prefix);
            if(p==null){
                return false;
            }else{
                return true;
            }
        }

        public TrieNode searchNode(String s){ //btrga33 pointer bta3 word
            s=s.toLowerCase();
            TrieNode p = root;
            for(int i=0; i<s.length(); i++){
                char c= s.charAt(i);
                int index;
                if((int)c<58 && (int)c>47) {
                    index = (int)c - 22;
                    //System.out.println("y5tyyyyyyy");
                } else
                    index = c-'a';
                if(p.arr[index]!=null){
                    p = p.arr[index];
                }else{
                    return null;
                }
            }

            if(p==root)
                return null;

            return p;
        }


    }
