package javaspeedtest;

import java.util.Random;

public class SpeedTest {
	
	public float upload_speed() {
		float result = new Random().nextFloat() * 100;
		System.out.println(result);
		return result;
	}
	
	public float download_speed() {
		float result = new Random().nextFloat() * 100;
		System.out.println(result);
		return result;
	}
	
	public float ping() {
		float result = new Random().nextFloat() * 100;
		System.out.println(result);
		return result;
	}

}
