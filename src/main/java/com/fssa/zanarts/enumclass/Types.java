package com.fssa.zanarts.enumclass;

/**
 * Enumeration representing different types of art.
 */
public enum Types {
    /**
     * Mandana art type.
     */
    MANDANA,
    
    /**
     * Watercolor art type.
     */
    WATERCOLOUR,
    
    /**
     * Sketch art type.
     */
    SKETCH,
    
    /**
     * Realism art type.
     */
    REALISM,
    
    /**
     * Hyperrealism art type.
     */
    HYPERREALISM;
    
    /**
     * Get the name of the art type.
     *
     * @return The name of the art type.
     */
    public String getTypes() {
        return this.name();
    }
}
