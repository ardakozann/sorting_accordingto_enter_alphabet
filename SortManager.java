import java.util.Scanner;

public class SortManager {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void start() {
		
		//isimler için toplu string
		System.out.println("Siralamasini kontrol etmek istediğiniz kelimeleri bosluk birakarak yaziniz:");
		String namesInString = scanner.nextLine();
		namesInString = namesInString.toLowerCase();
		
		//verilen harflere göre sıralama için alınan girdi
		System.out.println("Alfabetik sira icin karakterleri sirasiyla bosluksuz olarak yaziniz:");
		String alphabet = scanner.next();
		
		scanner.close();
		
		//isimleri parçalayarak diziye atama
		String [] names =namesInString.split(" ");

		System.out.println();
		boolean result =sorting(names, alphabet);
		if(result) {
			System.out.println("Siralama dogru.");
		}
		else {
			System.out.println("Siralama yanlis");
		}	
	}
	
	public boolean sorting(String[] names, String alphabet) {
		
		//52. satırda açıklaması ve altında işlevi gösterildi.
		int loopInWord;
		
		//kendisi ve bir sonraki kelimeyi karşılaştırmak için for döngüsü
		for(int i=0; i < names.length-1; i++) {

			//Eğer aynı kelime veya aynı kelime başlangıcı varsa hızlıca kontrol etmesi için
			if(names[i].equals(names[i+1])) {
				continue;
			}
			else if(names[i].contains(names[i+1])) {
				return false;
			}
			else if(names[i+1].contains(names[i])) {
				continue;
			}
			
			//index out of bounds hatası almamak için uzunluğu az olan kelimenin uzunluğu alınıyor
			if(names[i].length() > names[i+1].length()) {
				loopInWord=names[i].length();
			}
			else {
				loopInWord=names[i+1].length();
			}
			
			//Kendisi ve sonraki kelime içerisinde harf döngüsü
			for(int j=0; j<loopInWord-1; j++) {
				
				//İlk kelimenin sıraya göre herhangi bir harfi diğerinden önceyse sonraki kelimeye geçilir
				if(alphabet.indexOf(names[i].charAt(j)) < alphabet.indexOf(names[i+1].charAt(j))) {
					break;
				}
				//İlk kelimenin sıraya göre herhangi bir harfi diğerinden sonraysa metot false döner
				else if(alphabet.indexOf(names[i].charAt(j)) > alphabet.indexOf(names[i+1].charAt(j))) {
					return false;
				}
			}
		}
		return true;
	}
}
