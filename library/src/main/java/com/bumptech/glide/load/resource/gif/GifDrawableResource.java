package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

/**
 * A resource wrapping an {@link com.bumptech.glide.load.resource.gif.GifDrawable}.
 */
public class GifDrawableResource extends DrawableResource<GifDrawable> {
  public GifDrawableResource(GifDrawable drawable) {
    super(drawable);
  }

  @Override
  public Class<GifDrawable> getResourceClass() {
    return GifDrawable.class;
  }

  @Override
  public int getSize() {
   return drawable.getBuffer().limit() + Util.getBitmapByteSize(drawable.getFirstFrame());
  }

  @Override
  public void recycle() {
    drawable.stop();
    drawable.recycle();
  }
}
