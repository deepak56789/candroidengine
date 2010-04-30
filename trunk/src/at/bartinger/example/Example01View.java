package at.bartinger.example;

import android.content.Context;
import at.bartinger.candroid.CandroidSurfaceView;
import at.bartinger.candroid.renderable.Sprite;
import at.bartinger.candroid.renderer.SurfaceRenderer;
import at.bartinger.candroid.texture.Texture;
import at.bartinger.candroid.texture.TextureAtlas;
import at.bartinger.candroid.texture.TextureManager;

public class Example01View extends CandroidSurfaceView {
	
	
	private SurfaceRenderer spriteRenderer;
	
	Texture myTexture;
	Texture sun;
	Sprite mySprite;
	Sprite sunSprite;

	public Example01View(Context context ,boolean usesAccelerometer) {
		super(context, usesAccelerometer);
		
		//Create an new Renderer for your game.
		//The Renderer draws the game.
		spriteRenderer = new SurfaceRenderer();

		//The TextureAtlas is like a container. Add your required textures
		//to a new TextureAtlas so that the TextureManager can load them.
		TextureAtlas atlas = new TextureAtlas();

		//Texture is very important class. The parameter is just an path to an image.
		//It searches your image in the assets-folder which is automatically generated by creating 
		//an new Android-Project
		//I recommend you to make a graphics-folder in the assets folder to maintain the order.
		//Hint: I recommend to make extra folders for sounds, fonts, etc. too.
		myTexture = new Texture("graphics/candroid_logo.png");
		
		//Create another texture.
		sun = new Texture("graphics/sun2.gif");
		
		//Now add all your textures to your TextureAtlas.
		atlas.addTexture(myTexture);
		atlas.addTexture(sun);
	
		//Then use the static method load(...) to load all your textures.
		TextureManager.load(context, atlas);
		//Now you can use them to create Sprites
		
		//You need Sprites is an object of an image.
		//You use it to move,scale,rotate and other updates.
		mySprite = new Sprite(myTexture,100,100);
		sunSprite = new Sprite(sun,20,20);
		
		//Now you have to tell the Renderer that you want him to draw these Sprites.
		//All what you have to do is add them to your Renderer.
		spriteRenderer.addRenderable(mySprite);
		spriteRenderer.addRenderable(sunSprite);

		setRendererAndStart(spriteRenderer);
	}
	
	@Override
	public void recycle() {
		myTexture.recycle();
		sun.recycle();
		mySprite.recycle();
		sunSprite.recycle();
	}
	
	
	
	
	
}