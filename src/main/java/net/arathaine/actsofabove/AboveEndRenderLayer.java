package net.arathaine.actsofabove;

import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;

public class AboveEndRenderLayer extends RenderLayer {

    private static final Identifier ABOVE_TEXTURE = new Identifier("textures/environment/end_sky.png");
    private static final Identifier ABOVE_STARS_TEXTURE = new Identifier("textures/entity/end_portal.png");

    public AboveEndRenderLayer(String name, VertexFormat vertexFormat, VertexFormat.DrawMode drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
    }

    public static RenderLayer getRenderLayer() {

        MultiPhaseParameters multiPhaseParameters = MultiPhaseParameters.builder()
                .shader(RenderPhase.END_PORTAL_SHADER)
                .texture(RenderPhase.Textures.create().add(ABOVE_TEXTURE, false, false).add(ABOVE_STARS_TEXTURE, false, false).build())
                .build(false);

        return RenderLayer.of("above_end_aoa", VertexFormats.POSITION,
                VertexFormat.DrawMode.QUADS, 256, false, false, multiPhaseParameters);
    }
    

}
