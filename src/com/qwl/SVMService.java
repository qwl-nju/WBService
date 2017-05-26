package com.qwl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SVMService {
	public String Svm(String args) throws IOException{
		//String totxt = "27:1 28:1 55:1 56:1 83:1 84:1 111:1 112:1 139:1 140:1 167:1 168:1 195:1 196:1 223:1 224:1 236:1 251:1 252:1 262:1 263:1 264:1 279:1 280:1 289:1 291:1 307:1 308:1 316:1 318:1 319:1 335:1 336:1 345:1 346:1 363:1 364:1 374:1 391:1 392:1 401:1 402:1 419:1 420:1 428:1 444:1 447:1 448:1 453:1 454:1 471:1 472:1 475:1 476:1 482:1 487:1 497:1 498:1 499:1 500:1 503:1 504:1 507:1 508:1 523:1 524:1 525:1 526:1 527:1 528:1 531:1 532:1 539:1 541:1 551:1 553:1 554:1 555:1 556:1 559:1 560:1 563:1 564:1 565:1 566:1 569:1 575:1 578:1 579:1 580:1 581:1 582:1 583:1 584:1 587:1 588:1 590:1 591:1 592:1 594:1 595:1 615:1 616:1 643:1 644:1 671:1 672:1 699:1 700:1 727:1 728:1 755:1 756:1 783:1 784:1 ";
		String totxt= args;
		if(totxt.length()<3) return "";
    	String[] pre={totxt,"D:\\TPfiles\\javaflies\\SvmService\\data\\model.txt","D:\\TPfiles\\javaflies\\SvmService\\data\\pre.txt"};
//      svm_train train = new svm_train();
//      train.main(arg);
      svm_predict predict = new svm_predict();
      String res = predict.Main(pre);

    	return res;
	}
}
