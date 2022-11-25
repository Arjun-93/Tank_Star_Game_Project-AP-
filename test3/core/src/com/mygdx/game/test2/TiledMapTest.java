package com.mygdx.game.test2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class TiledMapTest extends ApplicationAdapter {
    private static final float scrollSpeed = 480f; // in pixels/s

    private MapRenderer mapRenderer;
    private OrthographicCamera camera;

    // keep these to simplify calculations
    private final Vector2 terrainSize = new Vector2();
    private final Vector2 screenSize = new Vector2();
    @Override public void create () {
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        loadMap("Map/TerrainBackgroungd.tmx");
    }

    @Override public void render () {
        handleInteractions();

        // sky
        Gdx.gl.glClearColor(.8f, .8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // map
        mapRenderer.render();
    }
    private void loadMap(final String mapFilename)
    {
        TiledMap map = new TmxMapLoader().load(mapFilename);

        // create renderer
        mapRenderer = new OrthogonalTiledMapRenderer(map);

        mapRenderer.setView(camera);

        // calculate & store terrain size
        TiledMapTileLayer terrain = (TiledMapTileLayer) map.getLayers().get(0);
        terrainSize.set(
                terrain.getWidth() * terrain.getTileWidth(),
                terrain.getHeight() * terrain.getTileHeight());
        screenSize.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    private void handleInteractions()
    {
        Vector2 direction = new Vector2(0f, 0f);

        // left/right
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))	direction.x--;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))	direction.x++;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))	direction.y--;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))	direction.y++;

        // normalize to get constant speed (whether in diagonal or straight)
        direction = direction.nor().scl(scrollSpeed * Gdx.graphics.getDeltaTime());

        camera.translate(direction);
        updateCamera();
    }
    private void updateCamera()
    {
        // clamp to terrain boundaries
        final float halfScreenWidth = screenSize.x/2;
        final float halfScreenHeight = screenSize.y/2;
        camera.position.x = MathUtils.clamp(camera.position.x, halfScreenWidth, terrainSize.x - halfScreenWidth);
        camera.position.y = MathUtils.clamp(camera.position.y, halfScreenHeight, terrainSize.y - halfScreenHeight);

        // apply
        camera.update();
        mapRenderer.setView(camera);
    }

}