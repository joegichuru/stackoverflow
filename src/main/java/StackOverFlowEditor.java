import com.intellij.ide.BrowserUtil;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class StackOverFlowEditor extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {

        PsiFile psiFile=event.getData(CommonDataKeys.PSI_FILE);
        Language language=psiFile.getLanguage();
        String name = language.getDisplayName();
        Editor editor=event.getData(CommonDataKeys.EDITOR);
        CaretModel caretModel=editor.getCaretModel();
        String selectedtext=caretModel.getCurrentCaret().getSelectedText();
        String query=selectedtext.replaceAll(" ","+")+"["+name+"]"+"isaccepted:yes";
        BrowserUtil.browse("https://stackoverflow.com/search?q="+query);

    }
}
