package org.lookout.interview;

public class LongestSubstringPalindrome {

	// This function prints the longest palindrome substring (LPS)
	// of str[]. It also returns the length of the longest palindrome
	public int longestPalSubstr(String str)
	{
	    int maxLength = 1;  // The result (length of LPS)
	 
	    int start = 0;
	    int len = str.length();
	 
	    int low, high;
	 
	    // One by one consider every character as center point of 
	    // even and length palindromes
	    for (int i = 1; i < len; ++i)
	    {
	        // Find the longest even length palindrome with center points
	        // as i-1 and i.  
	        low = i - 1;
	        high = i;
	        while (low >= 0 && high < len && str.charAt(low) == str.charAt(high))
	        {
	            if (high - low + 1 > maxLength)
	            {
	                start = low;
	                maxLength = high - low + 1;
	            }
	            --low;
	            ++high;
	        }
	 
	        // Find the longest odd length palindrome with center 
	        // point as i
	        low = i - 1;
	        high = i + 1;
	        while (low >= 0 && high < len && str.charAt(low) == str.charAt(high))
	        {
	            if (high - low + 1 > maxLength)
	            {
	                start = low;
	                maxLength = high - low + 1;
	            }
	            --low;
	            ++high;
	        }
	    }
	 
	    System.out.println("Longest palindrome substring is: ");
	    System.out.println(str.substring(start, start + maxLength));
	 
	    return maxLength;
	}
	public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n= s.length();
        int [] p = new int[2*n-1];
        
        int center=0, right=0, cur=0;
        while(cur<2*n-1){
            while(2*center-right>=0 && right<2*n-1 
                && (right%2==1 || s.charAt((2*center-right)/2)==s.charAt(right/2))){
                right++;
                p[center]++;
            }
            right=Math.max(right-1,center);
            p[center]= Math.max(p[center]-1,0);
            cur=center+1;
            while(2*center-cur>=0 && cur+p[2*center-cur]<right){
                p[cur]=p[2*center-cur];
                cur++;
            }
            if(cur<2*n-1){
                center=cur;
                if(right<center) right=center;
                p[center]=right-cur;
            }
        }
        
        String res="";
        for(int i=0;i<2*n-1;i++){      
            int start=0, end=0;
            if(i%2==1){
                start = i/2-(p[i]+1)/2+1;
                end = i/2+(1+p[i])/2;
            }else{
                start = i/2-p[i]/2;
                end = i/2+p[i]/2;
            }
            if(end-start+1>res.length())
                res=s.substring(start,end+1);
        }
        return res;
    }
	
	public static void main(String[] args) {
	 String str="FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
	 //System.out.println(new LongestSubstringPalindrome().longestPalSubstr(str));
	 String str1=new LongestSubstringPalindrome().longestPalindrome(str);
	 System.out.println("palindrome is: "+str1+" length is: "+str1.length());

	}

}
