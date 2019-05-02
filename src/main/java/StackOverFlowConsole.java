import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;

public class StackOverFlowConsole extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor=event.getData(CommonDataKeys.EDITOR);
        CaretModel caretModel=editor.getCaretModel();
        String selectedtext=caretModel.getCurrentCaret().getSelectedText();
        String query=selectedtext.replaceAll(" ","+")+"isaccepted:yes";
        BrowserUtil.browse("https://stackoverflow.com/search?q="+query);
    }
}
