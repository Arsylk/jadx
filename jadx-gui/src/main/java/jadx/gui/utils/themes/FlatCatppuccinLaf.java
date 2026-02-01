package jadx.gui.utils.themes;

import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.util.LoggingFacade;
import jadx.core.Jadx;

import java.io.IOException;
import java.io.InputStream;

public class FlatCatppuccinLaf extends IntelliJTheme.ThemeLaf
{
	public static final String NAME = "Catppuccin Mocha";
	public static boolean setup() {
		try {
			return setup(new FlatCatppuccinLaf());
		} catch(RuntimeException ex) {
			return false;
		}
	}

	public static void installLafInfo() {
		installLafInfo(NAME, FlatCatppuccinLaf.class);
	}

	public FlatCatppuccinLaf() {
		super(loadTheme("mocha.theme.json"));
	}

	@Override
	public String getName() {
		return NAME;
	}

	static IntelliJTheme loadTheme(String name) {
		try {
			InputStream stream = FlatCatppuccinLaf.class.getResourceAsStream("/themes/" + name);
			assert stream != null;
			return new IntelliJTheme(stream);
		} catch( IOException ex ) {
			String msg = "FlatLaf: Failed to load IntelliJ theme '" + name + "'";
			LoggingFacade.INSTANCE.logSevere(msg, ex);
			throw new RuntimeException(msg, ex);
		}
	}
}
