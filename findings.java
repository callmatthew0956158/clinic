public class findings {
    private double fbs, rbs, totalchol, hdl, ldl, triglycerides;
    private double creatinine, uricacid, bun, ast, alt;
    private double sodium, potassium, chloride, tcalcium, icalcium;

    public findings(double fbs, double rbs, double totalchol, double hdl,
                    double ldl, double triglycerides, double creatinine,
                    double uricacid, double bun, double ast, double alt,
                    double sodium, double potassium, double chloride,
                    double tcalcium, double icalcium) {

        this.fbs = fbs;
        this.rbs = rbs;
        this.totalchol = totalchol;
        this.hdl = hdl;
        this.ldl = ldl;
        this.triglycerides = triglycerides;
        this.creatinine = creatinine;
        this.uricacid = uricacid;
        this.bun = bun;
        this.ast = ast;
        this.alt = alt;
        this.sodium = sodium;
        this.potassium = potassium;
        this.chloride = chloride;
        this.tcalcium = tcalcium;
        this.icalcium = icalcium;
    }
    // getters
    public double getFbs() { 
        return fbs; 
    }
    public double getRbs() { 
        return rbs; 
    }
    public double getTotalChol() { 
        return totalchol;
    }
    public double getHdl() { 
        return hdl; 
    }
    public double getLdl() { 
        return ldl; 
    }
    public double getTriglycerides() { 
        return triglycerides; 
    }
    public double getCreatinine() { 
        return creatinine; 
    }
    public double getUricAcid() { 
        return uricacid; 
    }
    public double getBun() { 
        return bun; 
    }
    public double getAst() { 
        return ast; 
    }
    public double getAlt() { 
        return alt;
     }
    public double getSodium() { 
        return sodium; 
    }
    public double getPotassium() { 
        return potassium; 
    }
    public double getChloride() { 
        return chloride; 
    }
    public double getTotalCalcium() { 
        return tcalcium; 
    }
    public double getIonizedCalcium() { 
        return icalcium; 
    }
}
